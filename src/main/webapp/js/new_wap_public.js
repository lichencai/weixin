$(function(){
  //ͷ�� ��Ա��¼��ע�ᣨev_t_top_user�� ������ev_t_top_search�� ������ev_t_top_menu���Ƿ���ʾ
  $(".ev_t_top_user").click(function(){
    var data_user = $(this).attr('data-user');
    if(data_user == 0){
      if($('.ev_t_top_user_div').css('display') == 'none'){
        $(".ev_t_top_user_div").show();
        $(".ev_t_top_user_a").show();
        $(".ev_t_top_search_div").hide();
        $(".ev_t_top_search_a").hide();
      }else{
        $(".ev_t_top_user_div").hide();
        $(".ev_t_top_user_a").hide();
      }
    }

  });
  $(".ev_t_top_search").click(function(){
    if($('.ev_t_top_search_div').css('display') == 'none'){
      $(".ev_t_top_search_div").show();
      $(".ev_t_top_search_a").show();
      $(".ev_t_top_user_div").hide();
      $(".ev_t_top_user_a").hide();
    }else{
      $(".ev_t_top_search_div").hide();
      $(".ev_t_top_search_a").hide();
    }
  });
  $(".ev_t_top_menu").click(function(){
      var h = $(document).height();
      $(".ev_t_bg_kuang").height(h).show();
  });
  $(".ev_t_bg_kuang").click(function(){
      $(".ev_t_bg_kuang").hide();
  });

  //ҳ���������

  //����
  $(document).on("click",".ev_t_train_xin",function(){
      var that       = $(this);
      var username  = $('#username').val();
      var channel_id = $('#channel_id').val();
      var doc_id     = that.attr("data-doc-id");
      var type       = $('#channel_type').val();
      var title      = that.attr("data-title");
      var timestamp  = Date.parse(new Date());

  });
  //���
 $(".ev_t_train .ev_t_product_tit_sx").click(function(){
    if($('.ev_t_product_c2').css("display") == "none"){
      $(".ev_t_product_c2").show();
      $(".ev_t_product_c3").hide();
      $(".ev_t_product_c3_bg").hide();
      $(".ev_t_train .ev_t_product_tit_sx").addClass("ev_t_product_tit_open");
    }else{
      $(".ev_t_train .ev_t_product_tit_sx").removeClass("ev_t_product_tit_open");
      $(".ev_t_product_c2").hide();
	  $(".ev_t_product_c3").hide();
      $(".ev_t_product_c3_bg").hide();
    }
  });
 $(".ev_t_product_c2").on({
    click : function(){
      var index = $(this).index();
      if(index != 0){
        $(".ev_t_product_c3_bg").show();
        $(".ev_t_product_c3").show();
        $(".ev_t_product_c3 ul:eq("+(index-1)+")").show().siblings().hide();
      }
    }
  },"li");
  $(".ev_t_product_c2 .ev_t_product_c_div").each(function(){
    $(this).click(function(){
      var shuzi = $(this).parent().index();
      $(this).parent().addClass("ev_t_product_cur").siblings().removeClass("ev_t_product_cur");
      if($(this).parent().attr("class") == "ev_t_product_cur"){
        $(".ev_t_product_c3 i").addClass("ev_t_product_c_i");
        var iheight = 12+(shuzi-1)*$(this).parent().outerHeight();
        $(".ev_t_product_c_i").css("top",iheight+"px");
      }else{
        $(".ev_t_product_c3  i").removeClass("ev_t_product_c_i");
      }

    });
  });
  $(".ev_t_product_c2 .ev_t_product_c_both").each(function(){
    $(this).click(function(){
      $(this).parent().addClass("ev_t_product_cur").siblings().removeClass("ev_t_product_cur");
      $(".ev_t_product_c3_bg").hide();
      $(".ev_t_product_c3").hide();
      $(".ev_t_product_c2").hide();
    });
  });
  $(".ev_t_product_c3 .ev_t_product_c_div").each(function(){
    $(this).click(function(){
      $(this).parent().addClass("ev_t_product_cur").siblings().removeClass("ev_t_product_cur");
      if($(this).parent().attr("class") == "ev_t_product_cur"){
        $(".ev_t_product_c3_bg").hide();
        $(".ev_t_product_c3").hide();
        $(".ev_t_product_c2").hide();
        $(".ev_t_product_tit_sx").removeClass("ev_t_product_tit_open");
      }
    });
  });
  $(".ev_t_product_c3 .ev_t_product_c_both").each(function(){
    $(this).click(function(){
      $(this).parent().addClass("ev_t_product_cur").siblings().removeClass("ev_t_product_cur");
      if($(this).parent().attr("class") == "ev_t_product_cur"){
        $(".ev_t_product_c3_bg").hide();
        $(".ev_t_product_c3").hide();
        $(".ev_t_product_c2").hide();
      }
    });
  });
  $(".ev_t_product_c3_bg").click(function(){
    $(".ev_t_product_c3_bg").hide();
    $(".ev_t_product_c3").hide();
  });
  //������ϸҳ����ҳ
  $('.ev_t_product_pj_t .ev_t_product_more').click(function(){
      var _this = $(".ev_t_product_pj_t  .ev_t_product_more_div");
      if(_this.css("display") == "none"){
        _this.show();
      }else{
        _this.hide();
      }
  });
  //��Ʒ����
 $(".ev_t_product .ev_t_product_tit_px").click(function(){
      if($('.ev_t_product_c').css("display") == "none"){
        $(".ev_t_product_c").show();
        $(".ev_t_product_c2").hide();
        $(".ev_t_product_shaixuan").hide();
        $(".ev_t_product .ev_t_product_tit_sx").removeClass("ev_t_product_tit_open");
        $(".ev_t_product .ev_t_product_tit_px").addClass("ev_t_product_tit_open");
      }else{
        $(".ev_t_product_c").hide();
        $(".ev_t_product .ev_t_product_tit_px").removeClass("ev_t_product_tit_open");
      }
    });
    $(".ev_t_product .ev_t_product_tit_sx").click(function(){
      if($('.ev_t_product_shaixuan').css("display") == "none"){
        $(".ev_t_product_shaixuan").show();
        $(".ev_t_product_c").hide();
        $(".ev_t_product_c2").hide();
        $(".ev_t_product_c3").hide();
        $(".ev_t_product_c3_bg").hide();
        $(".ev_t_product .ev_t_product_tit_px").removeClass("ev_t_product_tit_open");
        $(".ev_t_product .ev_t_product_tit_sx").addClass("ev_t_product_tit_open");
      }else{
        $(".ev_t_product .ev_t_product_shaixuan").hide();
        $(".ev_t_product .ev_t_product_tit_sx").removeClass("ev_t_product_tit_open");
      }
    });

    $(".ev_t_product_shaixuan").on({click : function(){
        $(".ev_t_product_c2").show();
        $(".ev_t_product_shaixuan").hide();
        $(".ev_t_product_c3").hide();
        $(".ev_t_product_c3_bg").hide();
        var that = $(this),id = that.data("id");
        $(".ev_t_product_c2").find("ul").each(function(){
          if($(this).data("id")==id){
            $(this).show()
          }else{
            $(this).hide()
          }
        })
      }
    },"li");

    $(".ev_t_product_c2").on({
      click : function(){
        var index = $(this).index();
        if(index != 0){
          $(".ev_t_product_c3_bg").show();
          $(".ev_t_product_c3").show();
          $(".ev_t_product_c3 ul:eq("+(index-1)+")").show().siblings().hide();
          $(".ev_t_product_c_i").css("display","block");
        }
      }
    },"li")

    $(".ev_t_product_c2 .ev_t_product_c_both").each(function(){
      $(this).click(function(){
        $(this).parent().addClass("ev_t_product_cur").siblings().removeClass("ev_t_product_cur");
        $(".ev_t_product_c3_bg").hide();
        $(".ev_t_product_c3").hide();
        $(".ev_t_product_c2").hide();
        $(".ev_t_product_shaixuan").show();
      });
    });

    $(".ev_t_product_c2 .ev_t_product_c_div").each(function(){
      $(this).click(function(){
        var shuzi = $(this).parent().index();
        $(this).parent().addClass("ev_t_product_cur").siblings().removeClass("ev_t_product_cur");
        if($(this).parent().attr("class") == "ev_t_product_cur"){
          $(".ev_t_product_c3 i").addClass("ev_t_product_c_i");
          var iheight = 12+(shuzi-1)*$(this).parent().outerHeight();
          $(".ev_t_product_c_i").css("top",iheight+"px");
        }else{
          $(".ev_t_product_c3  i").removeClass("ev_t_product_c_i");
        }

      });
    });

    $(".ev_t_product_c3 .ev_t_product_c_div").each(function(){
      $(this).click(function(){
        $(this).parent().addClass("ev_t_product_cur").siblings().removeClass("ev_t_product_cur");
        if($(this).parent().attr("class") == "ev_t_product_cur"){
          $(".ev_t_product_c3_bg").hide();
          $(".ev_t_product_c3").hide();
          $(".ev_t_product_c2").hide();
          $(".ev_t_product_shaixuan").show();
        }
      });
    });
    $(".ev_t_product_c3 .ev_t_product_c_both").each(function(){
      $(this).click(function(){
        $(this).parent().addClass("ev_t_product_cur").siblings().removeClass("ev_t_product_cur");
        if($(this).parent().attr("class") == "ev_t_product_cur"){
          $(".ev_t_product_c3_bg").hide();
          $(".ev_t_product_c3").hide();
          $(".ev_t_product_c2").hide();
          $(".ev_t_product_shaixuan").show();
        }
      });
    });
    $(".ev_t_product_c3_bg").click(function(){
      $(".ev_t_product_c3_bg").hide();
      $(".ev_t_product_c3").hide();
    });
    $(".ev_t_product_qd").click(function(){
      $(".ev_t_product_shaixuan").hide();
      $(".ev_t_product_tit_sx").removeClass("ev_t_product_tit_open");
    });
    //�ղ�
    $(document).on("click", ".ev_t_product_xq_fx .ev_t_product_xq_zan , #detailNavCollect,.ev_t_train_xin" ,function(){
        var href       = window.location.href;
        var doc_id     = $(this).attr("data-doc-id");
        var username   = $('#username').val();
        var _this      = $(this);
        if(username){
          var channel_id = $('#channel_id').val();
          var type       = $('#channel_type').val();
          var title      = $(this).attr("data-title");
        }else{
          var title      = $(this).attr("data-title");
          var type       = $(this).attr("data-type");
          var channel_id = $(this).attr("data-channel-id");
          var username   = $(this).attr("data-username");
        }
        var timestamp  = Date.parse(new Date());
        var url        = '/dom/user_collect_add.php?timestamp='+timestamp;
        var data       = {
                          'title'     :title,
                          'type'      :type,
                          'doc_id'    :doc_id,
                          'channel_id':channel_id,
                          'username'  :username,
                          'wap'       :1
                        };
        $.ajax({
            'url' : url,
            type: "POST",
            async: false,
            cache: false,
            data:data,
            success: function(data) {
              if(data == 1){
                showAllzz("�ղسɹ���");
                if(_this.attr('class') == 'ev_t_train_xin'){
                  var num  = _this.find('span').html();
                  num = isNaN(parseInt(num)) ? 1 : parseInt(num)+1;
                  _this.find('span').html(num);
                }
                return false;
              }else if(data == 2){
                var loginUrl    = '/dom/denglu.php?username='+username+'&wap=1';
                var registerUrl = '/dom/zhuce.php?username='+username+'&wap=1';
                showAllzz('�ղ�ʧ�ܣ�����û�е�¼����¼�����������ղأ�',{'��¼':loginUrl,'ע��':registerUrl,'�ر�':'###'});
                return false;
              }else if(data == 3){
                showAllzz("���Ѿ��ղع������ڸ������Ĳ鿴��");
                return false;
              }else if(data == 4){
                showAllzz("��������");
                return false;
              }
            }
          })
          return false;
    });

});


$(function(){
  //����
    $(document).on('click',"#productFenxiang , #detailNavShare",function(){
       fengxiang();
    });

});

function search_website() {
  var keyword = $.trim($('.ev_t_top_search_input #top_keyword').val());
  if (!keyword) {
    showAllzz("�ؼ��ֲ���Ϊ��");
    return false;
  }
  $('.ev_t_top_search_a #search_form').submit();
}
