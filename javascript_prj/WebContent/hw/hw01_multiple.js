function printmulti(a){
	var line= a +"단\n";
	
	for(var b=1 ; b<=9; b++){
		line += a + " * " + b + " = " + (a*b) + "\n";
	}
	return line;
}