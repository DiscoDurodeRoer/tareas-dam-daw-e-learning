//xjxSWFup = xajax.ext.SWFupload;

xajax.ext.SWFupload.swf = null;

xajax.ext.SWFupload.forms = {};
xajax.ext.SWFupload.fields = {};
xajax.ext.SWFupload.queues = {};
xajax.ext.SWFupload.tools = {};

/* default upload settings */
xajax.ext.SWFupload.settings = {
	flash_url:xajax.ext.SWFupload.config.javascript_URI + "swfupload.swf",
	file_size_limit:"0",
	file_types:"*.*",
	file_types_description:"All Files",
	file_upload_limit:0,
	file_queue_limit:0,
	file_queue_error_handler:xajax.ext.SWFupload.tools.fileQueueError,
	debug:false,
	button_image_url:"img/button_500x22.gif",
	button_width:270,
	button_height:22,
	button_action:SWFUpload.BUTTON_ACTION.SELECT_FILES,
	button_window_mode:SWFUpload.WINDOW_MODE.TRANSPARENT,
	button_placeholder_id:'',
	button_text:'<span class="btnText">Select Files...</span>',
	button_text_style:".btnText { font-size: 10; font-weight: bold; font-family: MS Shell Dlg; }",
	button_text_top_padding:3,
	button_text_left_padding:100,
	post_params:{}
}

if ('undefined' == typeof xajax.ext.SWFupload.lang) {
	xajax.ext.SWFupload.lang = {};
	xajax.ext.SWFupload.lang.browseFiles = 'Browse Files';
	xajax.ext.SWFupload.lang.browseFile = 'Browse File';
}


/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.init
 arguments: config [object]

 Creates the SWFupload instance
 */

xajax.ext.SWFupload.configure = function (config) {
	if ("object" == typeof config) return xajax.ext.SWFupload.tools.mergeObj(this.settings, config);

	return this.settings;
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.addQueue
 arguments: child [object], parent [object], config [objeect ,multiple [bool]

 Creates a new a new file queue and stores the reference in this.queues
 */
xajax.ext.SWFupload.addQueue = function (child, parent, config, multiple) {
	var id = xajax.ext.SWFupload.tools.getId();
	this.queues[id] = new xajax.ext.SWFupload.tools.fileQueue(id, child, parent, config, multiple);

	return id;
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.applyConfig
 arguments: oQueue [object]

 Applies the queue's config on the SWFupload instance
 */
xajax.ext.SWFupload.applyConfig = function (oQueue) {

	var conf = oQueue.getConfig();
	var swf = xajax.ext.SWFupload.getInstance();

	if ('undefined' != typeof conf.file_types)
		swf.setFileTypes(conf.file_types, conf.file_types_description);

	if ('undefined' != typeof conf.file_size_limit)
		swf.setFileSizeLimit(conf.file_size_limit);

	if ('object' == typeof conf.post_params) {
		for (a in conf.post_params)
			swf.addPostParam(a, conf.post_params[a]);
	}

	swf.settings.file_queued_handler = function (oFile) {
		oQueue.addFile(oFile)
	};
	;
	swf.settings.file_queue_error_handler = oQueue.fileQueueError;
}
/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.selectFile
 arguments: oQueue [object]

 Onclick handler for selecting file
 */

xajax.ext.SWFupload.selectFile = function (oQueue) {
	this.applyConfig(oQueue);

	if (oQueue.getConfig().file_queue_limit > 0 && oQueue.getConfig().file_queue_limit <= oQueue.queued) return;

	xajax.ext.SWFupload.getInstance().selectFile();
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.selectFiles
 arguments: oQueue [object]

 Onclick handler for selecting files
 */

xajax.ext.SWFupload.selectFiles = function (oQueue) {
	this.applyConfig(oQueue);
	if (oQueue.getConfig().file_queue_limit > 0 && oQueue.getConfig().file_queue_limit <= oQueue.queued) return;
	xajax.ext.SWFupload.getInstance().selectFiles();
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.getInstance
 arguments:

 Return the SWFupload instance. If there's no instance available it creates a new one with default settings.
 */

xajax.ext.SWFupload.getInstance = function () {
	if (null == this.swf) this.swf = new SWFUpload(this.settings);

	return this.swf;
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.removeFile
 arguments: QueueId [integer] , FileId [integer]

 Removes the file (FileID) from queue (QueueId)
 */

xajax.ext.SWFupload.removeFile = function (QueueId, FileId, finished) {
	this.queues[QueueId].removeFile(FileId, finished);
}


/* ------------------------------------------------------------------------------------------------------------------------ */

xajax.ext.SWFupload.request = {};


/*
 function: xajax.ext.SWFupload.request.getFileFromQueue
 arguments: oRequest [object]

 Returns the first file from first available queue.
 Returns false if no files were selected
 */

xajax.ext.SWFupload.request.getFileFromQueue = function (oRequest) {


	var instances = {};
	var queued = 0;
	if ("string" == typeof oRequest.SWFform) {


		if ('object' != typeof xajax.ext.SWFupload.forms[oRequest.SWFform]) {
			return false;
		}
		for (a in xajax.ext.SWFupload.forms[oRequest.SWFform]) {
			var field = xajax.ext.SWFupload.forms[oRequest.SWFform][a];
			if (0 < xajax.ext.SWFupload.queues[field].queued) {
				oRequest.currentFile = xajax.ext.SWFupload.queues[field].getFile();
				oRequest.swf = xajax.ext.SWFupload.queues[field].getSWF();
				return true;
			}
			;
		}
	} else if ("string" == typeof oRequest.SWFfield) {
		if ('string' != typeof xajax.ext.SWFupload.fields[oRequest.SWFfield]) {
			return false;
		}

		var qId = xajax.ext.SWFupload.fields[oRequest.SWFfield];
		if (0 < xajax.ext.SWFupload.queues[qId].queued) {
			oRequest.currentFile = xajax.ext.SWFupload.queues[qId].getFile();
			oRequest.swf = xajax.ext.SWFupload.queues[qId].getSWF();
			return true;
		}
		;
	} else {

		for (var a in xajax.ext.SWFupload.queues) {
			if (0 < xajax.ext.SWFupload.queues[a].queued) {
				oRequest.currentFile = xajax.ext.SWFupload.queues[a].getFile();
				oRequest.swf = xajax.ext.SWFupload.queues[a].getSWF();
				return true;
			}
			;
		}
	}

	return false;
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.request.	xajax.ext.SWFupload.request.processParameters = function(oRequest)

 arguments: oRequest [object]

 Processes the parameters
 */

xajax.ext.SWFupload.request.processParameters = function (oRequest) {
	if ("SWFupload" == oRequest.mode) {
		oRequest.currentFile = false;
		xajax.ext.SWFupload.request.getFileFromQueue(oRequest);
		if (oRequest.currentFile)	oRequest.method = 'GET';
	}
	return xajax.ext.SWFupload.bak.processParameters(oRequest);
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.request.	xajax.ext.SWFupload.request.prepareRequest = function(oRequest)

 arguments: oRequest [object]

 doesn't to anything at all when there's a file selected for upload
 */

xajax.ext.SWFupload.request.prepareRequest = function (oRequest) {
	if ("SWFupload" == oRequest.mode && false != oRequest.currentFile) return;
	return xajax.ext.SWFupload.bak.prepareRequest(oRequest);
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.request.	xajax.ext.SWFupload.request.submitRequest = function(oRequest)

 arguments: oRequest [object]

 Submits the request either via SWFupload or XHR
 */

xajax.ext.SWFupload.request.submitRequest = function (oRequest) {
	if ("SWFupload" == oRequest.mode && false != oRequest.currentFile) {

		if (oRequest.requestURI) {
			//backup requestURI, otherwise xajax.responseReceived() is going to delete our url
			oRequest.bak_requestURI = oRequest.requestURI;
		} else if (oRequest.bak_requestURI) {
			oRequest.requestURI = oRequest.bak_requestURI;
		}

		var swf = oRequest.swf;

		var fileQueue = xajax.ext.SWFupload.queues[oRequest.currentFile.QueueId];

		swf.customSettings.currentFile = oRequest.currentFile;
		swf.setFilePostName(swf.customSettings.currentFile.name);

		swf.customSettings.oRequest = oRequest;
		swf.setUploadURL(oRequest.requestURI);

		swf.settings.upload_success_handler = function (oFile, response) {
			var xx = xajax;
			var xt = xx.tools;
			var xcb = xx.callback;
			var gcb = xcb.global;
			var lcb = oRequest.callback;

			var oRet = oRequest.returnValue;
			var isXML = '<' == response.substr(0,1) ? true : false;


			var FileId = swf.customSettings.currentFile;
			if ('function' == typeof this.old_upload_success_handler) this.old_upload_success_handler(oFile);
			xcb.execute([gcb, lcb], 'onSuccess', oRequest);

			var seq = 0;
			if (isXML)
			{
				if (response) {
					var responseXML = (new DOMParser()).parseFromString(response, "text/xml");
					if (responseXML.documentElement) {
						oRequest.status.onProcessing();

						var child = responseXML.documentElement.firstChild;
						oRet = xt.xml.processFragment(child, seq, oRet, oRequest);
					}
				}

			}
			else {
				if (response) {
					try {
						var responseJSON = eval('('+response+')');
					} catch (ex) {
						throw(ex);
					}
					if ( ('object' == typeof responseJSON) && ('object' == typeof responseJSON.xjxobj) ) {
						oRequest.status.onProcessing();
						oRet = xt.json.processFragment(responseJSON, seq, oRet, oRequest);
					} else {
					}
				}
			}



			var obj = {};
			obj.fullName = 'Response Complete';
			obj.sequence = seq;
			obj.request = oRequest;
			obj.context = oRequest.context;
			obj.cmd = 'rcmplt';
			xt.queue.push(xx.response, obj);

			// do not re-start the queue if a timeout is set
			if (null == xx.response.timeout)
				xt.queue.process(xx.response);
		}

		swf.settings.upload_complete_handler = function (oFile) {

			var qFile = this.customSettings.currentFile;
			xajax.ext.SWFupload.removeFile(qFile.QueueId, qFile.id, true);

			if (!xajax.ext.SWFupload.request.getFileFromQueue(oRequest)) {
				if ('function' == typeof oRequest.onUploadComplete) oRequest.onUploadComplete();
				return;
			}

			xajax.ext.SWFupload.request.submitRequest(oRequest);
		}


		swf.settings.upload_start_handler = function (oFile) {
			if ('function' == typeof this.old_upload_start_handler) this.old_upload_start_handler(oFile);
			oRequest.startTime = new Date();

		}
		swf.settings.upload_progress_handler = function (oFile, bytesLoaded, bytesTotal) {

			upload = {};
			upload.received = bytesLoaded;
			upload.total = bytesTotal;
			upload.state = "uploading";
			var reqTime = new Date();

			upload.lastbytes = oRequest.lastbytes;
			upload.now = reqTime.getTime() / 1000;
			upload.start = oRequest.startTime.getTime() / 1000;

			var step = upload.received / (upload.total / 100);
			var progressbar = xajax.$('SWFup_progress_' + oFile.id);
			var w = Math.round(220 * step / 100);
			progressbar.style.width = w + 'px';

			var progress = xajax.$("swf_queued_filesize_" + oFile.id);
			var elapsed = upload.now - upload.start;
			var rate = xajax.ext.SWFupload.tools.formatBytes(upload.received / elapsed).toString() + '/s';
			progress.innerHTML = "<i>" + rate + "</i> " + xajax.ext.SWFupload.tools.formatBytes(upload.received) + "/" + xajax.ext.SWFupload.tools.formatBytes(upload.total);
			oRequest.lastbytes = upload.received;

		}

		swf.settings.upload_error_handler = function (file, errorCode, message) {
			// Skipe error when a file is removed from queue (abort)
			if (-280 == errorCode) return;
			if (file == null) {
				fileName = '';
			} else {
				fileName = file.name;
			}

			alert("Error Code: " + errorCode + ", File name: " + fileName + ", Message: " + message);
		};
		swf.startUpload(swf.customSettings.currentFile.id);
		return;
	}
	return xajax.ext.SWFupload.bak.submitRequest(oRequest);
}


/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.tools.queueFile
 arguments: oFile,QueueId,QueueContainer

 */
xajax.ext.SWFupload.tools.queueFile = function (oFile, name, QueueId, QueueContainer) {

	this.id = oFile.id;
	this.name = name;
	this.QueueId = QueueId;

	var container = document.createElement('div');
	container.id = "SWFup_" + this.id;
	container.className = "swf_queued_file";

	this.elm = container;

	var remove = document.createElement('div');
	remove.className = "swf_queued_file_remove";
	remove.innerHTML = "&nbsp;";

	var id = this.id;
	var QueueId = this.QueueId;
	remove.onclick = function () {
		xajax.ext.SWFupload.removeFile(QueueId, id);
	}
	container.appendChild(remove);

	var label = document.createElement('div');
	label.className = "swf_queued_filename";
	label.innerHTML = oFile.name;
	container.appendChild(label);

	var progress_container = document.createElement('div');
	progress_container.className = "swf_queued_file_progress_container";
	container.appendChild(progress_container);


	var progress = document.createElement('div');
	progress.className = "swf_queued_file_progress_bar";
	progress.style.width = '1px';
	progress.id = 'SWFup_progress_' + oFile.id;
	progress_container.appendChild(progress);


	var fSize = document.createElement('div');
	fSize.className = "swf_queued_filesize";
	fSize.id = "swf_queued_filesize_" + this.id;
	fSize.innerHTML = xajax.ext.SWFupload.tools.formatBytes(oFile.size);
	container.appendChild(fSize);

	var fClear = document.createElement('div');
	fClear.style.clear = 'both';
	container.appendChild(fClear);
	QueueContainer.appendChild(container);

	this.container = container;
	this.oFile = oFile;

	this.destroy = function () {
		QueueContainer.removeChild(container);
	}

	return;
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.tools.fileQueue
 arguments: id [integer],child [object], parent [object], multiple [bool]

 parses the form for fields
 */

xajax.ext.SWFupload.tools.fileQueue = function (id, child, parent, config, multiple) {


	this.id = id;
	var config = 'object' == typeof config ? xajax.ext.SWFupload.tools.mergeObj(xajax.ext.SWFupload.settings, config) : xajax.ext.SWFupload.settings;
	this.queued = 0;
	this.files = {};
	this.queue = null;

	this.getConfig = function () {
		return config;
	}

	var tmpName = child.name;
	var container = document.createElement('div');
	container.id = 'SWFbuttonContainer_' + tmpName;
	container.className = 'swf_browse_button';
	parent.appendChild(container);


	var container2 = document.createElement('div');
	container2.id = 'SWFbutton_' + tmpName;
	container.appendChild(container2);

	parent.removeChild(child);

	var oQueue = this;
	if (true === multiple) {
		config.button_action = SWFUpload.BUTTON_ACTION.SELECT_FILES;
	} else {
		config.button_action = SWFUpload.BUTTON_ACTION.SELECT_FILE;

	}

	var QueueContainer = document.createElement('div');
	QueueContainer.id = 'SWFqueue_' + this.id;
	QueueContainer.className = 'swf_queue_container';
	parent.appendChild(QueueContainer);

	config.button_placeholder_id = container2.id;

	var foo = this;

	var fieldname = child.name;
	this.addFile = function (oFile) {
		foo.files[oFile.id] = new xajax.ext.SWFupload.tools.queueFile(oFile, fieldname, foo.id, QueueContainer);
		foo.queued++;
		if (foo.queued == config.file_queue_limit) foo.swf.setButtonDisabled(true);
	}

	this.getFile = function (FileId) {
		if ("undefined" != typeof FileId) return foo.files[FileId];
		for (a in foo.files) return foo.files[a];
		return false;
	}

	this.purge = function (d) {
		var a = d.attributes, i, l, n;
		if (a) {
			l = a.length;
			for (i = 0; i < l; i += 1) {
				n = a[i].name;
				if (typeof d[n] === 'function') {
					d[n] = null;
				}
			}
		}
		a = d.childNodes;
		if (a) {
			l = a.length;
			for (i = 0; i < l; i += 1) {
				this.purge(d.childNodes[i]);
			}
		}
	}

	this.removeFile = function (FileId, finished) {

		foo.swf.cancelUpload(FileId);

		foo.queued--;
		if (foo.queued <= config.file_queue_limit) foo.swf.setButtonDisabled(false);
		var filediv = xajax.$("SWFup_" + foo.files[FileId].id);
		filediv.className = true === finished ? 'swf_queued_file_finished' : 'swf_queued_file_removed';
		setTimeout(function () {
			xajax.ext.SWFupload.tools.FadeOut(filediv, 100);
		}, xajax.ext.SWFupload.config.FadeTimeOut);

		foo.files[FileId] = null;
		delete foo.files[FileId];
	}
	this.destroy = function () {

		this.swf.destroy();
		delete(this.swf);
		for (a in foo.files) {
			foo.files[a].destroy();
			delete (foo.files[a]);
		}
		foo.queued = 0;
		delete(foo);
	}
	this.fileQueueError = function (swf, code, msg) {
		if (-110 == code) {
			msg = "Die gew&auml;hlte Datei ist zu gro&szlig;!";
			alert(msg);
		}
	}

	this.getSWF = function () {
		return this.swf;

	}

	config.file_queued_handler = this.addFile;
	config.file_queue_error_handler = this.fileQueueError;

	this.swf = new SWFUpload(config);

}
/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.tools._parseFields
 arguments: children [array],parent [object], config [object], multiple [bool]

 parses the form for fields
 */


xajax.ext.SWFupload.tools._parseFields = function (children, parent, config, multiple) {
	var result = {};
	var iLen = children.length;
	for (var i = 0; i < iLen; ++i) {
		var child = children[i];
		if ('undefined' != typeof child.childNodes)
			var res2 = xajax.ext.SWFupload.tools._parseFields(child.childNodes, child, config, multiple);
		result = xajax.ext.SWFupload.tools.mergeObj(result, res2);
		if (child.name) {
			if ('file' == child.type) {
				result[child.name] = xajax.ext.SWFupload.addQueue(child, parent, config, multiple);
			}
		}
	}
	return result;
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.tools.transForm
 arguments: form_id [integer] ,config [object] ,multiple [bool]

 transforms the all fields of the given form into fileQueue instances
 */

xajax.ext.SWFupload.tools.transForm = function (form_id, config, multiple) {
	var oForm = xajax.$(form_id);
	if (oForm)
		if (oForm.childNodes) {
			var fields = xajax.ext.SWFupload.tools._parseFields(oForm.childNodes, oForm, config, multiple);
			xajax.ext.SWFupload.forms[form_id] = fields;
		}
	return;
}

/* ------------------------------------------------------------------------------------------------------------------------ */

/*
 function: xajax.ext.SWFupload.tools.transField
 arguments: field_id [integer] ,config [object] ,multiple [bool]

 transforms the given field into a fileQueue instance
 */

xajax.ext.SWFupload.tools.transField = function (field_id, config, multiple) {
	try {
		var oField = xajax.$(field_id);
		if ('undefined' != typeof oField) return xajax.ext.SWFupload.fields[field_id] = xajax.ext.SWFupload.addQueue(oField, oField.parentNode, config, multiple);

	} catch (ex) {
	}
	return;
}


/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.tools.destroyForm
 arguments: form_id [integer]

 destroys the given form
 */

xajax.ext.SWFupload.tools.destroyForm = function (form_id) {
	if ("undefined" == typeof xajax.ext.SWFupload.forms[form_id]) return;
	for (a in xajax.ext.SWFupload.forms[form_id]) {
		var key = xajax.ext.SWFupload.forms[form_id][a];
		xajax.ext.SWFupload.queues[key].destroy();
		delete xajax.ext.SWFupload.queues[key];
	}
	delete xajax.ext.SWFupload.forms[form_id];
	return;
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.tools.destroyField
 arguments: field_id [integer]

 destroys the given field
 */

xajax.ext.SWFupload.tools.destroyField = function (field_id) {
	if ("undefined" == typeof xajax.ext.SWFupload.fields[field_id]) return;
	var key = xajax.ext.SWFupload.fields[field_id];
	xajax.ext.SWFupload.queues[key].destroy();
	delete(xajax.ext.SWFupload.queues[key]);
	delete xajax.ext.SWFupload.fields[field_id];

	return true;
}

/* ------------------------------------------------------------------------------------------------------------------------ */

/*
 function: xajax.ext.SWFupload.tools.FadeOut
 arguments: elm [object], opacity [integer]

 fades a div
 */

xajax.ext.SWFupload.tools.FadeOut = function (elm, opacity) {
	var reduceOpacityBy = 15;
	var rate = 40;
	if (opacity > 0) {
		opacity -= reduceOpacityBy;
		if (opacity < 0) {
			opacity = 0;
		}

		if (elm.filters) {
			try {
				elm.filters.item("DXImageTransform.Microsoft.Alpha").opacity = opacity;
			} catch (e) {
				// If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
				elm.style.filter = "progid:DXImageTransform.Microsoft.Alpha(opacity=" + opacity + ")";
			}
		} else {
			elm.style.opacity = opacity / 100;
		}
	}

	if (opacity > 0) {
		var oSelf = this;
		setTimeout(function () {
			xajax.ext.SWFupload.tools.FadeOut(elm, opacity);
		}, rate);
	} else {
		var parent = elm.parentNode;
		parent.removeChild(elm);
	}
}


/* ------------------------------------------------------------------------------------------------------------------------ */

/*
 function: xajax.ext.SWFupload.tools.formatBytes
 arguments: bytes [integer]

 returns string with formatted size (kB / MB)
 */

xajax.ext.SWFupload.tools.formatBytes = function (bytes) {

	var ret = {};
	if (bytes / 1204 < 1024) {
		return (Math.round(bytes / 1024 * 100) / 100).toString() + " kB";
	} else {
		return (Math.round(bytes / 1024 / 1024 * 100) / 100).toString() + " MB";
	}
	return ret;
}

/* ------------------------------------------------------------------------------------------------------------------------ */

/*
 function: xajax.ext.SWFupload.tools.mergeObj
 arguments: n objects

 Merges all objects and returns a single object.
 Newrt keys override existing keys.

 */

xajax.ext.SWFupload.tools.mergeObj = function () {
	if ('object' != typeof arguments) return;

	var res = {};
	var len = arguments.length;
	for (var i = 0; i < len; i++) {
		var obj = arguments[i];
		for (a in obj) {
			res[a] = obj[a];
		}
	}
	return res;
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.ext.SWFupload.tools.getId
 arguments:

 returns a 'unique' (rand) id
 */

xajax.ext.SWFupload.tools.getId = function () {
	var pid_str = "";
	for (i = 0; i <= 3; i++) {
		var pid = 0;
		pid = Math.random();
		while (Math.ceil(pid).toString().length < 8) {
			pid *= 10;
		}
		pid = Math.ceil(pid).toString();
		pid_str = pid_str + pid.toString();
	}
	return pid_str;
}

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.command.handler.register('SWFup_dfi')
 arguments: object

 xajax response command for ext.SWFupload.tools.destroyField
 */
xajax.command.handler.register('SWFup_dfi', function (args) {
	args.cmdFullName = 'ext.SWFupload.tools.destroyField';
	xajax.ext.SWFupload.tools.destroyField(args.id);
	return true;
});

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.command.handler.register('SWFup_dfo')
 arguments: object

 xajax response command for ext.SWFupload.tools.destroyForm
 */

xajax.command.handler.register('SWFup_dfo', function (args) {
	args.cmdFullName = 'ext.SWFupload.tools.destroyForm';
	xajax.ext.SWFupload.tools.destroyForm(args.id);
	return true;
});

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.command.handler.register('SWFup_tfi'I
 arguments: object

 xajax response command for ext.SWFupload.tools.transField
 */

xajax.command.handler.register('SWFup_tfi', function (args) {
	args.cmdFullName = 'ext.SWFupload.tools.transField';

//			if ("string" == typeof args.data.config.upload_complete_handler) {
//				try {
//					eval("var foo = "+args.data.config.upload_complete_handler);
//					args.data.config.upload_complete_handler = foo;
//				} catch(ex) {delete(args.data.config.upload_complete_handler);}
//			}

	if ("string" == typeof args.data.config.upload_success_handler) {
		try {
			eval("var foo = " + args.data.config.upload_success_handler);
			args.data.config.upload_success_handler = foo;
		} catch (ex) {
			delete(args.data.config.upload_success_handler);
		}
	}

	xajax.ext.SWFupload.tools.transField(args.id, args.data.config, args.data.multi);
	return true;
});

/* ------------------------------------------------------------------------------------------------------------------------ */
/*
 function: xajax.command.handler.register('SWFup_tfo']
 arguments: object

 xajax response command for ext.SWFupload.tools.transForm
 */
xajax.command.handler.register('SWFup_tfo', function (args) {
	try {
		args.cmdFullName = 'ext.SWFupload.tools.transForm';
//		if ("string" == typeof args.data.config.upload_complete_handler) 
//		{
//			try {
//				eval("var foo = "+args.data.config.upload_complete_handler);
//				args.data.config.upload_complete_handler = foo;
//			} catch(ex) {delete(args.data.config.upload_complete_handler);}
//		}

		if ("string" == typeof args.data.config.upload_success_handler) {
			try {
				eval("var foo = " + args.data.config.upload_success_handler);
				args.data.config.upload_success_handler = foo;
			} catch (ex) {
				delete(args.data.config.upload_success_handler);
			}
		}
		xajax.ext.SWFupload.tools.transForm(args.id, args.data.config, args.data.multi);

	} catch (ex) {

	}


	return true;


});
/* ------------------------------------------------------------------------------------------------------------------------ */


xajax.ext.SWFupload.bak = {};
xajax.ext.SWFupload.bak.prepareRequest = xajax.prepareRequest;
xajax.ext.SWFupload.bak.submitRequest = xajax.submitRequest;
xajax.ext.SWFupload.bak.responseProcessor = xajax.responseProcessor;
xajax.ext.SWFupload.bak.processParameters = xajax.processParameters;

xajax.prepareRequest = xajax.ext.SWFupload.request.prepareRequest;
xajax.submitRequest = xajax.ext.SWFupload.request.submitRequest;
xajax.processParameters = xajax.ext.SWFupload.request.processParameters;


/* ------------------------------------------------------------------------------------------------------------------------ */


// -------------------------------------------------------------------------------------------------------------------------------------
/*

 Function: DOMParser

 Prototype DomParser for IE/Opera

 */
if (typeof DOMParser == "undefined") {
	DOMParser = function () {
	}

	DOMParser.prototype.parseFromString = function (str, contentType) {
		if (typeof ActiveXObject != "undefined") {
			var d = new ActiveXObject("Microsoft.XMLDOM");
			d.loadXML(str);
			return d;
		} else if (typeof XMLHttpRequest != "undefined") {
			var req = new XMLHttpRequest;
			req.open("GET", "data:" + (contentType || "application/xml") +
				";charset=utf-8," + encodeURIComponent(str), false);
			if (req.overrideMimeType) {
				req.overrideMimeType(contentType);
			}
			req.send(null);
			return req.responseXML;
		}
	}
}
