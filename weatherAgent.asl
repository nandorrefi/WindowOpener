
+raining: true
	<- .send(windowController, achieve, rain).

+~raining: true
	<- .send(windowController, achieve, ~rain).
	
+isSunny: true
	<- .send(shutterController, achieve, sunny).
	
+~isSunny: true
	<- .send(shutterController, achieve, ~sunny).
