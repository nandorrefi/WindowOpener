			
+extHot
	: intHot
	<- .send(windowController, achieve, close).
		
+extHot
	: intCold
	<- .send(windowController, achieve, open).
	
+extCold
	: intCold
	<- .send(windowController, achieve, close).
		
+extCold
	: intHot
	<- .send(windowController, achieve, open).

