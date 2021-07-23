/* 객체 만들기 */
var car ={
	name : "소나타", cc: 1600, color: "black", door: 4,
	start: function(){/* 시동 on */
		alert(this.name+" 시동 on");
	
	},
	stop: function(){/* 시동 off */
		alert(this.name+" 시동 off")
	},
	carInfo: function() {/* 차 정보 출력 */
		alert("차 이름: " + this.name + ", 차 cc: " + this.cc
			+ ", 차 색상: " + this.color + ", 문 개수: " + this.door);
	}
}
		
console.log(car.name);
console.log(car.cc);
		
car.start();
car.stop();
car.carInfo();

/* object함수로 객체 만들기*/

var car2 = new Object();
car2.name = "소나타";
car2.cc= 1600;
car2.color= "black";
car2.door= 4;
car2.start= function(){/* 시동 on */
	alert(this.name+" 시동 on");

};
car2.stop= function(){/* 시동 off */
	alert(this.name+" 시동 off")
};
car2.carInfo= function() {/* 차 정보 출력 */
	alert("차 이름= " + this.name + ", 차 cc= " + this.cc
		+ ", 차 색상= " + this.color + ", 문 개수= " + this.door);
};

console.log(car2.name);
console.log(car2.color);
		
car2.start();
car2.stop();
car2.carInfo();