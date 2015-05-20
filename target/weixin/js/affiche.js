function affiche(opts){
	this.obj = opts.obj;
	this.axis = opts.axis || 'left';
	this.speed = opts.speed || 'normal';
	this.type = opts.type || 'single';
	this.stime = 5000;
	this.moveW = 0;
}
affiche.fn = affiche.prototype = {
	init : function(){
		var typeJson = {flow:{slowly:150,slow:100,normal:60,quick:30,quickly:3},single:{slowly:5000,slow:4000,normal:3000,quick:2000,quickly:1000}};
		this.stime = typeJson[this.type][this.speed];
	},
	getStyle : function(obj,sName){
		var style = obj.currentStyle ? obj.currentStyle[sName] : getComputedStyle(obj,false)[sName];
		return style;
	},
	play : function(){//alert(1);
		if(!this.obj) return;
		if(this.axis == 'left' || this.axis == 'right'){
			this.obj.style.width = "99999px";
			var w = 0,
				childLi = this.obj.getElementsByTagName("li"),
				lul = document.createElement("ul"),
				pw = parseInt(this.getStyle(this.obj.parentNode,'width'));
			for(var i=0;i<childLi.length;i++){
				childLi[i].style.cssFloat = 'left';
				var lw = Math.ceil(parseFloat(this.getStyle(childLi[i],'width')));
//				if(lw < pw){
//					childLi[i].style.width = pw + "px";
//					lw = pw;
//				}
				var cli = childLi[i].cloneNode(true);
				lul.appendChild(cli);
				w += lw;
			}
			this.obj.style.width = w * 2 + "px";
			this.obj.innerHTML = this.obj.innerHTML+lul.innerHTML;
			this.moveW = w;
			this.Lmove();
		}
		if(this.axis == 'top' || this.axis == 'bottom'){
			var ph = parseInt(this.getStyle(this.obj.parentNode,'height')),
				h = parseInt(this.getStyle(this.obj,'height')),
				childLi = this.obj.getElementsByTagName("li"),
				lul = document.createElement("ul");
			for(var i = 0;i < childLi.length;i++){
				var lh = Math.ceil(parseFloat(this.getStyle(childLi[i],'height')));
				var cli = childLi[i].cloneNode(true);
				lul.appendChild(cli);
				h += lh;
			}
			this.obj.innerHTML = this.obj.innerHTML+lul.innerHTML;
			this.moveW = h;
			this.Tmove();
		}
	},
	Tmove : function(){
		var that = this,i = 0,time;
		
		time= setInterval(function(){
			that.obj.style.marginTop = -i+"px";
			i++;
			if(i > that.moveW){
				i = 0;
			}
		},that.stime);
	},
	Lmove : function(){
		var that = this,i = 0,time 
		
		time= setInterval(function(){
			that.obj.style.marginLeft = -i+"px";
			i++;
			if(i > that.moveW){
				i = 0;
			}
		},that.stime);
	},
	start : function(){
		this.init();
		this.play();
	}
}