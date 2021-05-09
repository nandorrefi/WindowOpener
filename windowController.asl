
+checkSensors: true
	<- checkSensors.

+!rain[source(weatherAgent)]: true
	<- closeWindow;
	+isRaining.
	
+!~rain[source(weatherAgent)]: true
	<- -isRaining.
	
+!open[source(tempAgent)]
	: not isRaining
	<- openWindow.

+!close[source(tempAgent)]
	: true
	<- closeWindow.
