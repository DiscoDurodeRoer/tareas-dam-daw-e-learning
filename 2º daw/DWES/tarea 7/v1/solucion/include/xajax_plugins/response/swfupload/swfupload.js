
var SWFUpload;if(SWFUpload==undefined){SWFUpload=function(settings){this.initSWFUpload(settings);};}
SWFUpload.prototype.initSWFUpload=function(settings){try{this.customSettings={};this.settings=settings;this.eventQueue=[];this.movieName="SWFUpload_"+SWFUpload.movieCount++;this.movieElement=null;SWFUpload.instances[this.movieName]=this;this.initSettings();this.loadFlash();this.displayDebugInfo();}catch(ex){delete SWFUpload.instances[this.movieName];throw ex;}
};SWFUpload.instances={};SWFUpload.movieCount=0;SWFUpload.version="2.2.0 Beta 3";SWFUpload.QUEUE_ERROR={QUEUE_LIMIT_EXCEEDED:-100,
FILE_EXCEEDS_SIZE_LIMIT:-110,
ZERO_BYTE_FILE:-120,
INVALID_FILETYPE:-130
};SWFUpload.UPLOAD_ERROR={HTTP_ERROR:-200,
MISSING_UPLOAD_URL:-210,
IO_ERROR:-220,
SECURITY_ERROR:-230,
UPLOAD_LIMIT_EXCEEDED:-240,
UPLOAD_FAILED:-250,
SPECIFIED_FILE_ID_NOT_FOUND:-260,
FILE_VALIDATION_FAILED:-270,
FILE_CANCELLED:-280,
UPLOAD_STOPPED:-290
};SWFUpload.FILE_STATUS={QUEUED:-1,
IN_PROGRESS:-2,
ERROR:-3,
COMPLETE:-4,
CANCELLED:-5
};SWFUpload.BUTTON_ACTION={SELECT_FILE:-100,
SELECT_FILES:-110,
START_UPLOAD:-120
};SWFUpload.CURSOR={ARROW:-1,
HAND:-2
};SWFUpload.WINDOW_MODE={WINDOW:"window",
TRANSPARENT:"transparent",
OPAQUE:"opaque"
};SWFUpload.prototype.initSettings=function(){this.ensureDefault=function(settingName,defaultValue){this.settings[settingName]=(this.settings[settingName]==undefined)? defaultValue:this.settings[settingName];};this.ensureDefault("upload_url","");this.ensureDefault("file_post_name","Filedata");this.ensureDefault("post_params",{});this.ensureDefault("use_query_string",false);this.ensureDefault("requeue_on_error",false);this.ensureDefault("http_success",[]);this.ensureDefault("file_types","*.*");this.ensureDefault("file_types_description","All Files");this.ensureDefault("file_size_limit",0);this.ensureDefault("file_upload_limit",0);this.ensureDefault("file_queue_limit",0);this.ensureDefault("flash_url","swfupload.swf");this.ensureDefault("prevent_swf_caching",true);this.ensureDefault("button_image_url","");this.ensureDefault("button_width",1);this.ensureDefault("button_height",1);this.ensureDefault("button_text","");this.ensureDefault("button_text_style","color: #000000; font-size: 16pt;");this.ensureDefault("button_text_top_padding",0);this.ensureDefault("button_text_left_padding",0);this.ensureDefault("button_action",SWFUpload.BUTTON_ACTION.SELECT_FILES);this.ensureDefault("button_disabled",false);this.ensureDefault("button_placeholder_id",null);this.ensureDefault("button_cursor",SWFUpload.CURSOR.ARROW);this.ensureDefault("button_window_mode",SWFUpload.WINDOW_MODE.WINDOW);this.ensureDefault("debug",false);this.settings.debug_enabled=this.settings.debug;this.settings.return_upload_start_handler=this.returnUploadStart;this.ensureDefault("swfupload_loaded_handler",null);this.ensureDefault("file_dialog_start_handler",null);this.ensureDefault("file_queued_handler",null);this.ensureDefault("file_queue_error_handler",null);this.ensureDefault("file_dialog_complete_handler",null);this.ensureDefault("upload_start_handler",null);this.ensureDefault("upload_progress_handler",null);this.ensureDefault("upload_error_handler",null);this.ensureDefault("upload_success_handler",null);this.ensureDefault("upload_complete_handler",null);this.ensureDefault("debug_handler",this.debugMessage);this.ensureDefault("custom_settings",{});this.customSettings=this.settings.custom_settings;if(this.settings.prevent_swf_caching){this.settings.flash_url=this.settings.flash_url+"?swfuploadrnd="+Math.floor(Math.random()*999999999);}
delete this.ensureDefault;};SWFUpload.prototype.loadFlash=function(){if(this.settings.button_placeholder_id!==""){this.replaceWithFlash();}else{this.appendFlash();}
};SWFUpload.prototype.appendFlash=function(){var targetElement,container;if(document.getElementById(this.movieName)!==null){throw "ID "+this.movieName+" is already in use. The Flash Object could not be added";}
targetElement=document.getElementsByTagName("body")[0];if(targetElement==undefined){throw "Could not find the 'body' element.";}
container=document.createElement("div");container.style.width="1px";container.style.height="1px";container.style.overflow="hidden";targetElement.appendChild(container);container.innerHTML=this.getFlashHTML();if(window[this.movieName]==undefined){window[this.movieName]=this.getMovieElement();}
};SWFUpload.prototype.replaceWithFlash=function(){var targetElement,tempParent;if(document.getElementById(this.movieName)!==null){throw "ID "+this.movieName+" is already in use. The Flash Object could not be added";}
targetElement=document.getElementById(this.settings.button_placeholder_id);if(targetElement==undefined){throw "Could not find the placeholder element.";}
tempParent=document.createElement("div");tempParent.innerHTML=this.getFlashHTML();targetElement.parentNode.replaceChild(tempParent.firstChild,targetElement);if(window[this.movieName]==undefined){window[this.movieName]=this.getMovieElement();}
};SWFUpload.prototype.getFlashHTML=function(){return ['<object id="',this.movieName,'" type="application/x-shockwave-flash" data="',this.settings.flash_url,'" width="',this.settings.button_width,'" height="',this.settings.button_height,'" class="swfupload">',
'<param name="wmode" value="',this.settings.button_window_mode,'" />',
'<param name="movie" value="',this.settings.flash_url,'" />',
'<param name="quality" value="high" />',
'<param name="menu" value="false" />',
'<param name="allowScriptAccess" value="always" />',
'<param name="flashvars" value="'+this.getFlashVars()+'" />',
'</object>'].join("");};SWFUpload.prototype.getFlashVars=function(){var paramString=this.buildParamString();var httpSuccessString=this.settings.http_success.join(",");return ["movieName=",encodeURIComponent(this.movieName),
"&amp;uploadURL=",encodeURIComponent(this.settings.upload_url),
"&amp;useQueryString=",encodeURIComponent(this.settings.use_query_string),
"&amp;requeueOnError=",encodeURIComponent(this.settings.requeue_on_error),
"&amp;httpSuccess=",encodeURIComponent(httpSuccessString),
"&amp;params=",encodeURIComponent(paramString),
"&amp;filePostName=",encodeURIComponent(this.settings.file_post_name),
"&amp;fileTypes=",encodeURIComponent(this.settings.file_types),
"&amp;fileTypesDescription=",encodeURIComponent(this.settings.file_types_description),
"&amp;fileSizeLimit=",encodeURIComponent(this.settings.file_size_limit),
"&amp;fileUploadLimit=",encodeURIComponent(this.settings.file_upload_limit),
"&amp;fileQueueLimit=",encodeURIComponent(this.settings.file_queue_limit),
"&amp;debugEnabled=",encodeURIComponent(this.settings.debug_enabled),
"&amp;buttonImageURL=",encodeURIComponent(this.settings.button_image_url),
"&amp;buttonWidth=",encodeURIComponent(this.settings.button_width),
"&amp;buttonHeight=",encodeURIComponent(this.settings.button_height),
"&amp;buttonText=",encodeURIComponent(this.settings.button_text),
"&amp;buttonTextTopPadding=",encodeURIComponent(this.settings.button_text_top_padding),
"&amp;buttonTextLeftPadding=",encodeURIComponent(this.settings.button_text_left_padding),
"&amp;buttonTextStyle=",encodeURIComponent(this.settings.button_text_style),
"&amp;buttonAction=",encodeURIComponent(this.settings.button_action),
"&amp;buttonDisabled=",encodeURIComponent(this.settings.button_disabled),
"&amp;buttonCursor=",encodeURIComponent(this.settings.button_cursor)
].join("");};SWFUpload.prototype.getMovieElement=function(){if(this.movieElement==undefined){this.movieElement=document.getElementById(this.movieName);}
if(this.movieElement===null){throw "Could not find Flash element";}
return this.movieElement;};SWFUpload.prototype.buildParamString=function(){var postParams=this.settings.post_params;var paramStringPairs=[];if(typeof(postParams)==="object"){for(var name in postParams){if(postParams.hasOwnProperty(name)){paramStringPairs.push(encodeURIComponent(name.toString())+"="+encodeURIComponent(postParams[name].toString()));}
}
}
return paramStringPairs.join("&amp;");};SWFUpload.prototype.destroy=function(){try{this.cancelUpload(null,false);;var movieElement=null;movieElement=this.getMovieElement();if(movieElement){for(var i in movieElement){try{if(typeof(movieElement[i])==="function"){movieElement[i]=null;}
}catch(ex1){}
}
try{movieElement.parentNode.removeChild(movieElement);}catch(ex){}
}
window[this.movieName]=null;SWFUpload.instances[this.movieName]=null;delete SWFUpload.instances[this.movieName];this.movieElement=null;this.settings=null;this.customSettings=null;this.eventQueue=null;this.movieName=null;return true;}catch(ex1){alert(ex);return false;}
};SWFUpload.prototype.displayDebugInfo=function(){this.debug(
[
"---SWFUpload Instance Info---\n",
"Version: ",SWFUpload.version,"\n",
"Movie Name: ",this.movieName,"\n",
"Settings:\n",
"\t","upload_url:               ",this.settings.upload_url,"\n",
"\t","flash_url:                ",this.settings.flash_url,"\n",
"\t","use_query_string:         ",this.settings.use_query_string.toString(),"\n",
"\t","requeue_on_error:         ",this.settings.requeue_on_error.toString(),"\n",
"\t","http_success:             ",this.settings.http_success.join(", "),"\n",
"\t","file_post_name:           ",this.settings.file_post_name,"\n",
"\t","post_params:              ",this.settings.post_params.toString(),"\n",
"\t","file_types:               ",this.settings.file_types,"\n",
"\t","file_types_description:   ",this.settings.file_types_description,"\n",
"\t","file_size_limit:          ",this.settings.file_size_limit,"\n",
"\t","file_upload_limit:        ",this.settings.file_upload_limit,"\n",
"\t","file_queue_limit:         ",this.settings.file_queue_limit,"\n",
"\t","debug:                    ",this.settings.debug.toString(),"\n",
"\t","prevent_swf_caching:      ",this.settings.prevent_swf_caching.toString(),"\n",
"\t","button_placeholder_id:    ",this.settings.button_placeholder_id.toString(),"\n",
"\t","button_image_url:         ",this.settings.button_image_url.toString(),"\n",
"\t","button_width:             ",this.settings.button_width.toString(),"\n",
"\t","button_height:            ",this.settings.button_height.toString(),"\n",
"\t","button_text:              ",this.settings.button_text.toString(),"\n",
"\t","button_text_style:        ",this.settings.button_text_style.toString(),"\n",
"\t","button_text_top_padding:  ",this.settings.button_text_top_padding.toString(),"\n",
"\t","button_text_left_padding: ",this.settings.button_text_left_padding.toString(),"\n",
"\t","button_action:            ",this.settings.button_action.toString(),"\n",
"\t","button_disabled:          ",this.settings.button_disabled.toString(),"\n",
"\t","custom_settings:          ",this.settings.custom_settings.toString(),"\n",
"Event Handlers:\n",
"\t","swfupload_loaded_handler assigned:  ",(typeof this.settings.swfupload_loaded_handler==="function").toString(),"\n",
"\t","file_dialog_start_handler assigned: ",(typeof this.settings.file_dialog_start_handler==="function").toString(),"\n",
"\t","file_queued_handler assigned:       ",(typeof this.settings.file_queued_handler==="function").toString(),"\n",
"\t","file_queue_error_handler assigned:  ",(typeof this.settings.file_queue_error_handler==="function").toString(),"\n",
"\t","upload_start_handler assigned:      ",(typeof this.settings.upload_start_handler==="function").toString(),"\n",
"\t","upload_progress_handler assigned:   ",(typeof this.settings.upload_progress_handler==="function").toString(),"\n",
"\t","upload_error_handler assigned:      ",(typeof this.settings.upload_error_handler==="function").toString(),"\n",
"\t","upload_success_handler assigned:    ",(typeof this.settings.upload_success_handler==="function").toString(),"\n",
"\t","upload_complete_handler assigned:   ",(typeof this.settings.upload_complete_handler==="function").toString(),"\n",
"\t","debug_handler assigned:             ",(typeof this.settings.debug_handler==="function").toString(),"\n"
].join("")
);};SWFUpload.prototype.addSetting=function(name,value,default_value){if(value==undefined){return(this.settings[name]=default_value);}else{return(this.settings[name]=value);}
};SWFUpload.prototype.getSetting=function(name){if(this.settings[name]!=undefined){return this.settings[name];}
return "";};SWFUpload.prototype.callFlash=function(functionName,argumentArray){argumentArray=argumentArray||[];var movieElement=this.getMovieElement();var returnValue,returnString;try{returnString=movieElement.CallFunction('<invoke name="'+functionName+'" returntype="javascript">'+__flash__argumentsToXML(argumentArray,0)+'</invoke>');returnValue=eval(returnString);}catch(ex){throw "Call to "+functionName+" failed";}
if(returnValue!=undefined&&typeof returnValue.post==="object"){returnValue=this.unescapeFilePostParams(returnValue);}
return returnValue;};SWFUpload.prototype.selectFile=function(){this.callFlash("SelectFile");};SWFUpload.prototype.selectFiles=function(){this.callFlash("SelectFiles");};SWFUpload.prototype.startUpload=function(fileID){this.callFlash("StartUpload",[fileID]);};SWFUpload.prototype.cancelUpload=function(fileID,triggerErrorEvent){if(triggerErrorEvent!==false){triggerErrorEvent=true;}
this.callFlash("CancelUpload",[fileID,triggerErrorEvent]);};SWFUpload.prototype.stopUpload=function(){this.callFlash("StopUpload");};SWFUpload.prototype.getStats=function(){return this.callFlash("GetStats");};SWFUpload.prototype.setStats=function(statsObject){this.callFlash("SetStats",[statsObject]);};SWFUpload.prototype.getFile=function(fileID){if(typeof(fileID)==="number"){return this.callFlash("GetFileByIndex",[fileID]);}else{return this.callFlash("GetFile",[fileID]);}
};SWFUpload.prototype.addFileParam=function(fileID,name,value){return this.callFlash("AddFileParam",[fileID,name,value]);};SWFUpload.prototype.removeFileParam=function(fileID,name){this.callFlash("RemoveFileParam",[fileID,name]);};SWFUpload.prototype.setUploadURL=function(url){this.settings.upload_url=url.toString();this.callFlash("SetUploadURL",[url]);};SWFUpload.prototype.setPostParams=function(paramsObject){this.settings.post_params=paramsObject;this.callFlash("SetPostParams",[paramsObject]);};SWFUpload.prototype.addPostParam=function(name,value){this.settings.post_params[name]=value;this.callFlash("SetPostParams",[this.settings.post_params]);};SWFUpload.prototype.removePostParam=function(name){delete this.settings.post_params[name];this.callFlash("SetPostParams",[this.settings.post_params]);};SWFUpload.prototype.setFileTypes=function(types,description){this.settings.file_types=types;this.settings.file_types_description=description;this.callFlash("SetFileTypes",[types,description]);};SWFUpload.prototype.setFileSizeLimit=function(fileSizeLimit){this.settings.file_size_limit=fileSizeLimit;this.callFlash("SetFileSizeLimit",[fileSizeLimit]);};SWFUpload.prototype.setFileUploadLimit=function(fileUploadLimit){this.settings.file_upload_limit=fileUploadLimit;this.callFlash("SetFileUploadLimit",[fileUploadLimit]);};SWFUpload.prototype.setFileQueueLimit=function(fileQueueLimit){this.settings.file_queue_limit=fileQueueLimit;this.callFlash("SetFileQueueLimit",[fileQueueLimit]);};SWFUpload.prototype.setFilePostName=function(filePostName){this.settings.file_post_name=filePostName;this.callFlash("SetFilePostName",[filePostName]);};SWFUpload.prototype.setUseQueryString=function(useQueryString){this.settings.use_query_string=useQueryString;this.callFlash("SetUseQueryString",[useQueryString]);};SWFUpload.prototype.setRequeueOnError=function(requeueOnError){this.settings.requeue_on_error=requeueOnError;this.callFlash("SetRequeueOnError",[requeueOnError]);};SWFUpload.prototype.setHTTPSuccess=function(http_status_codes){if(typeof http_status_codes==="string"){http_status_codes=http_status_codes.replace(" ","").split(",");}
this.settings.http_success=http_status_codes;this.callFlash("SetHTTPSuccess",[http_status_codes]);};SWFUpload.prototype.setDebugEnabled=function(debugEnabled){this.settings.debug_enabled=debugEnabled;this.callFlash("SetDebugEnabled",[debugEnabled]);};SWFUpload.prototype.setButtonImageURL=function(buttonImageURL){if(buttonImageURL==undefined){buttonImageURL="";}
this.settings.button_image_url=buttonImageURL;this.callFlash("SetButtonImageURL",[buttonImageURL]);};SWFUpload.prototype.setButtonDimensions=function(width,height){this.settings.button_width=width;this.settings.button_height=height;var movie=this.getMovieElement();if(movie!=undefined){movie.style.width=width+"px";movie.style.height=height+"px";}
this.callFlash("SetButtonDimensions",[width,height]);};SWFUpload.prototype.setButtonText=function(html){this.settings.button_text=html;this.callFlash("SetButtonText",[html]);};SWFUpload.prototype.setButtonTextPadding=function(left,top){this.settings.button_text_top_padding=top;this.settings.button_text_left_padding=left;this.callFlash("SetButtonTextPadding",[left,top]);};SWFUpload.prototype.setButtonTextStyle=function(css){this.settings.button_text_style=css;this.callFlash("SetButtonTextStyle",[css]);};SWFUpload.prototype.setButtonDisabled=function(isDisabled){this.settings.button_disabled=isDisabled;this.callFlash("SetButtonDisabled",[isDisabled]);};SWFUpload.prototype.setButtonAction=function(buttonAction){this.settings.button_action=buttonAction;this.callFlash("SetButtonAction",[buttonAction]);};SWFUpload.prototype.setButtonCursor=function(cursor){this.settings.button_cursor=cursor;this.callFlash("SetButtonCursor",[cursor]);};SWFUpload.prototype.queueEvent=function(handlerName,argumentArray){if(argumentArray==undefined){argumentArray=[];}else if(!(argumentArray instanceof Array)){argumentArray=[argumentArray];}
var self=this;if(typeof this.settings[handlerName]==="function"){this.eventQueue.push(function(){this.settings[handlerName].apply(this,argumentArray);});setTimeout(function(){self.executeNextEvent();},0);}else if(this.settings[handlerName]!==null){throw "Event handler "+handlerName+" is unknown or is not a function";}
};SWFUpload.prototype.executeNextEvent=function(){var f=this.eventQueue ? this.eventQueue.shift():null;if(typeof(f)==="function"){f.apply(this);}
};SWFUpload.prototype.unescapeFilePostParams=function(file){var reg=/[$]([0-9a-f]{4})/i;var unescapedPost={};var uk;if(file!=undefined){for(var k in file.post){if(file.post.hasOwnProperty(k)){uk=k;var match;while((match=reg.exec(uk))!==null){uk=uk.replace(match[0],String.fromCharCode(parseInt("0x"+match[1],16)));}
unescapedPost[uk]=file.post[k];}
}
file.post=unescapedPost;}
return file;};SWFUpload.prototype.flashReady=function(){var movieElement=this.getMovieElement();if(typeof(movieElement.CallFunction)==="unknown"){this.debug("Removing Flash functions hooks (this should only run in IE and should prevent memory leaks)");for(var key in movieElement){try{if(typeof(movieElement[key])==="function"){movieElement[key]=null;}
}catch(ex){}
}
}
this.queueEvent("swfupload_loaded_handler");};SWFUpload.prototype.fileDialogStart=function(){this.queueEvent("file_dialog_start_handler");};SWFUpload.prototype.fileQueued=function(file){file=this.unescapeFilePostParams(file);this.queueEvent("file_queued_handler",file);};SWFUpload.prototype.fileQueueError=function(file,errorCode,message){file=this.unescapeFilePostParams(file);this.queueEvent("file_queue_error_handler",[file,errorCode,message]);};SWFUpload.prototype.fileDialogComplete=function(numFilesSelected,numFilesQueued){this.queueEvent("file_dialog_complete_handler",[numFilesSelected,numFilesQueued]);};SWFUpload.prototype.uploadStart=function(file){file=this.unescapeFilePostParams(file);this.queueEvent("return_upload_start_handler",file);};SWFUpload.prototype.returnUploadStart=function(file){var returnValue;if(typeof this.settings.upload_start_handler==="function"){file=this.unescapeFilePostParams(file);returnValue=this.settings.upload_start_handler.call(this,file);}else if(this.settings.upload_start_handler!=undefined){throw "upload_start_handler must be a function";}
if(returnValue===undefined){returnValue=true;}
returnValue=!!returnValue;this.callFlash("ReturnUploadStart",[returnValue]);};SWFUpload.prototype.uploadProgress=function(file,bytesComplete,bytesTotal){file=this.unescapeFilePostParams(file);this.queueEvent("upload_progress_handler",[file,bytesComplete,bytesTotal]);};SWFUpload.prototype.uploadError=function(file,errorCode,message){file=this.unescapeFilePostParams(file);this.queueEvent("upload_error_handler",[file,errorCode,message]);};SWFUpload.prototype.uploadSuccess=function(file,serverData){file=this.unescapeFilePostParams(file);this.queueEvent("upload_success_handler",[file,serverData]);};SWFUpload.prototype.uploadComplete=function(file){file=this.unescapeFilePostParams(file);this.queueEvent("upload_complete_handler",file);};SWFUpload.prototype.debug=function(message){this.queueEvent("debug_handler",message);};SWFUpload.prototype.debugMessage=function(message){if(this.settings.debug){var exceptionMessage,exceptionValues=[];if(typeof message==="object"&&typeof message.name==="string"&&typeof message.message==="string"){for(var key in message){if(message.hasOwnProperty(key)){exceptionValues.push(key+": "+message[key]);}
}
exceptionMessage=exceptionValues.join("\n")||"";exceptionValues=exceptionMessage.split("\n");exceptionMessage="EXCEPTION: "+exceptionValues.join("\nEXCEPTION: ");SWFUpload.Console.writeLine(exceptionMessage);}else{SWFUpload.Console.writeLine(message);}
}
};SWFUpload.Console={};SWFUpload.Console.writeLine=function(message){var console,documentForm;try{console=document.getElementById("SWFUpload_Console");if(!console){documentForm=document.createElement("form");document.getElementsByTagName("body")[0].appendChild(documentForm);console=document.createElement("textarea");console.id="SWFUpload_Console";console.style.fontFamily="monospace";console.setAttribute("wrap","off");console.wrap="off";console.style.overflow="auto";console.style.width="700px";console.style.height="350px";console.style.margin="5px";documentForm.appendChild(console);}
console.value+=message+"\n";console.scrollTop=console.scrollHeight-console.clientHeight;}catch(ex){alert("Exception: "+ex.name+" Message: "+ex.message);}
};