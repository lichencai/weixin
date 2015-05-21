var ajaxInfo = {
	page	  : 2,
	timestamp : Date.parse(new Date())
};

ajaxInfo.editPromptMsg = function() {
	alert("该功能不支持编辑模式下查看！");
}

ajaxInfo.itemList = function (type, username, channelId) {
	username 	= $.trim(username);
	channelId 	= parseInt(channelId);
	type 		= parseInt(type);

	if (!username || !channelId) return false;

	$.ajax({
		'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		//dataType: "json",
		data: {"type":type, "username":username, "channel_id":channelId, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#listMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}

ajaxInfo.docList = function (type, username, channelId, big_id, sub_id, style) {
	username 	= $.trim(username);
	channelId 	= parseInt(channelId);
	type 		= parseInt(type);
	big_id 		= parseInt(big_id);
	sub_id 		= parseInt(sub_id);

	if (!username || !channelId) return false;

	$.ajax({
		'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":type, "username":username, "channel_id":channelId, "big_id":big_id, "sub_id":sub_id, "style":style, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#listMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}

ajaxInfo.serverList = function (type, username, channelId, big_id) {
	username 	= $.trim(username);
	channelId 	= parseInt(channelId);
	type 		= parseInt(type);
	big_id 		= parseInt(big_id);

	if (!username || !channelId) return false;

	$.ajax({
		'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":type, "username":username, "channel_id":channelId, "big_id":big_id, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#listMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}

ajaxInfo.productList = function (type, username, channelId, big_id, sub_id, sort, style) {
	username 	= $.trim(username);
	channelId 	= parseInt(channelId);
	type 		= parseInt(type);
	big_id 		= parseInt(big_id);
	sub_id 		= parseInt(sub_id);

	if (!username || !channelId) return false;

	$.ajax({
		'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":type, "username":username, "channel_id":channelId, "big_id":big_id, "sub_id":sub_id, "sort":sort, "style":style, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#listMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}

ajaxInfo.picList = function (type, username, channelId) {
	username 	= $.trim(username);
	channelId 	= parseInt(channelId);
	type 		= parseInt(type);

	if (!username || !channelId) return false;

	$.ajax({
		'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":type, "username":username, "channel_id":channelId, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#listMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}

ajaxInfo.userMemberList = function (type, username, status) {
	username 	= $.trim(username);
	type 			= parseInt(type);
	status 		= parseInt(status);

	if (!username) return false;

	$.ajax({
		'url' : "/wap/ajax_user.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":type, "username":username, "status":status, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#messageMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
					if (myObj.type == 1) {
						liList();
					}
				}
			}
		}
	})
	return false;
}

ajaxInfo.userNoticeList = function (type, username) {
	username 	= $.trim(username);
	type 			= parseInt(type);

	if (!username) return false;

	$.ajax({
		'url' : "/wap/ajax_user.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":type, "username":username, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#messageMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
					if (myObj.type == 1) {
						liList();
					}
				}
			}
		}
	})
	return false;
}

ajaxInfo.guestBookList = function (type, username, channelId) {
	username 		= $.trim(username);
	channelId 	= parseInt(channelId);
	type 				= parseInt(type);

	if (!username || !channelId) return false;

	$.ajax({
		'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":type, "username":username, "channel_id":channelId, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#listMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
					conUnBind();
					conBind();
				}
			}
		}
	})
	return false;
}

ajaxInfo.userOrderList = function (status, username) {
	username 	= $.trim(username);
	status		= parseInt(status);
	if (!username) return false;

	$.ajax({
		'url' : "/wap/ajax_user.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":3, "ostatus":status, "username":username, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#orderMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
					$(".orderSH").off("click");
					$(".orderFail").off("click");
					orderDels();
  					orderSH();
				}
			}
		}
	})
	return false;
}

ajaxInfo.userCouponList = function (channel_id, username, big_id) {
	username = $.trim(username);
	if (!username) return false;

	big_id = parseInt(big_id);
	$.ajax({
		'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":41, "channel_id":channel_id, "big_id":big_id, "username":username, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) {
					$("#listMore").remove();
				}
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}

ajaxInfo.userCenterNoticeList = function (type, username, status) {
	username = $.trim(username);
	type     = parseInt(type);
	status   = parseInt(status);

	if (!username || !status) return false;

	$.ajax({
		'url' : "/wap/ajax_user.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":type, "status":status, "username":username, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#messageMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}


ajaxInfo.ActivityList = function (channel_id, username, big_id) {
	username = $.trim(username);
	if (!username) return false;

	big_id = parseInt(big_id);
	$.ajax({
		'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":42, "channel_id":channel_id, "big_id":big_id, "username":username, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) {
					$("#listMore").remove();
				}
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}

ajaxInfo.userCenterActivityList = function (channel_id, username, status) {
	username = $.trim(username);
	if (!username) return false;

	status = parseInt(status);
	$.ajax({
		'url' : "/wap/ajax_user.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":8, "channel_id":channel_id, "status":status, "username":username, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) {
					$("#listMore").remove();
				}
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}

ajaxInfo.userReservationList = function (username) {
	username = $.trim(username);
	if (!username) return false;

	$.ajax({
		'url' : "/wap/ajax_user.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":4, "username":username, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) {
					$("#orderMore").remove();
				}
				if (myObj.con) {
					$("#reservationList").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}

ajaxInfo.userWapSearch = function (username, navtype, keyword) {
	username = $.trim(username);
	keyword = $.trim(keyword);
	navtype = parseInt(navtype);
	if (!username || !keyword || !navtype) {
		return false;
	}

	$.ajax({
		'url' : "/wap/ajax_set.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		data: {"type":3, "username":username, "navtype":navtype, "keyword":keyword, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) {
					$("#listMore").remove();
				}
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}
//我的收藏
ajaxInfo.collectList = function(username,collect_channel){
	username  = $.trim(username);
	collect_channel = parseInt(collect_channel);
	if (!username) { return false; }
	$.ajax({
	'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		//dataType: "json",
		data: {"type":44,"username":username, "collect_channel":collect_channel, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#listMore").remove();
				if (myObj.con) {
					$("#my_collect_list").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
}
ajaxInfo.productPl = function (type, username, channelId, id) {
	username  = $.trim(username);
	channelId = parseInt(channelId);
	type      = parseInt(type);
	id        = parseInt(id);

	if (!username || !channelId || !id) { return false; }

	$.ajax({
		'url' : "/wap/ajax.php?timestamp="+ ajaxInfo.timestamp,
		type: "POST",
		async: false,
		cache: false,
		//dataType: "json",
		data: {"type":type, "username":username, "channel_id":channelId, "id":id, "pl":1, "page":ajaxInfo.page},
		success: function(data) {
			if ($.trim(data) != 'fail') {
				var myObj = eval('('+data+')');
				if (myObj.end == 1) $("#listMore").remove();
				if (myObj.con) {
					$("#contents").append(myObj.con);
					ajaxInfo.page++;
				}
			}
		}
	})
	return false;
}
