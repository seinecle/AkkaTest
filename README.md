#AKKA vs regular Java
##Results:

#TEST 1	
double loop through an array of 1,000 integers	
operation: product of elements of arrays	

<table>
  <tr>
    <th>nb of actors / operations</th><th><b>Akka (in milliseconds)</b></th><th><b>Regular java (in milliseconds)</b></th>
  </tr>
  <tr>
    <td>10</td><td>150</td><td>150</td>
  </tr>
  <tr>
    <td>100</td><td>1,200</td><td>5,600</td>
  </tr>
    <tr>
    <td>1000</td><td>11,000</td><td>56,000</td>
  </tr>
</table>	
	
<br>
###<b>conclusion test 1: Akka is faster by a factor of 5.</b>

#TEST 2	
double loop through an array of 10,000 integers	
operation: do some complex regex ops on a random String for each of the 10,000 steps	

<table>
  <tr>
    <th>nb of actors / operations</th><th><b>Akka (in milliseconds)</b></th><th><b>Regular java (in milliseconds)</b></th>
  </tr>
  <tr>
    <td>10</td><td>348</td><td>874</td>
  </tr>
  <tr>
    <td>100</td><td>2,231</td><td>7,600</td>
  </tr>
    <tr>
    <td>1000</td><td>20,000</td><td>75,000</td>
  </tr>
</table>	

<br>
###<b>conclusion test 2: Akka is faster by a factor of 3 to 4.</b>
    
	
-----
by [Clement Levallois](http://clementlevallois.net)