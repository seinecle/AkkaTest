#AKKA vs regular Java
##Results:

#TEST 1	
double loop through an array of 1,000 integers	
operation: product of elements of arrays	
	
			in milliseconds	
Akka:	
10 actors -> 60	
100 actors	460  
1000 actors	3,500	
	
	
regular Java:	
10 tasks	12  
100 tasks	60  
1000 tasks	560  
<br>
###<b>conclusion test 1: Akka is slower by a factor of 5.</b>

#TEST 2	
double loop through an array of 10,000 integers	
operation: do some complex regex ops on a randon String for each of the 10,000 steps	
	
			in milliseconds  
akka:	
10 actors	348  
100 actors	2,231  	
1000 actors	20,000  
	
	
BENCHMARK:	
10 tasks	874  
100 tasks	7,600  
1000 tasks	75,000  
<br>
###<b>conclusion test 2: Akka is faster by a factor of 2 or 3.</b>
    
	
-----
by [Clement Levallois](http://clementlevallois.net)