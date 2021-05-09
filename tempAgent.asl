			
+extHot
	: intHot
	<- .print("Got hot signal");
		.send(windowController, achieve, close).
		
+extHot
	: intCold
	<- .print("Got hot signal");
		.send(windowController, achieve, open).
	
+extCold
	: intCold
	<- .print("Got cold signal");
		.send(windowController, achieve, close).
		
+extCold
	: intHot
	<- .print("Got cold signal");
		.send(windowController, achieve, open).

