
+!extHot[source(A)]
	: intHot
	<- .print("Got hot signal from ", A);
		closeWindow.
		
+!extHot[source(A)]
	: intCold
	<- .print("Got hot signal from ", A);
		openWindow.
	
+!extCold[source(A)]
	: intCold
	<- .print("Got cold signal from ", A);
		closeWindow.
		
+!extCold[source(A)]
	: intHot
	<- .print("Got cold signal from ", A);
		openWindow.
