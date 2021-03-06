package edu.umb.cs680.hw04;

import java.util.Iterator;
import java.util.LinkedList;

public class PrimeGenerator {
	protected long from, to;
	protected LinkedList<Long> primes = new LinkedList<Long>();

	public PrimeGenerator(long from, long to){
		if(from >= 1 && to > from){
			this.from = from;
			this.to = to;
		}else{
			throw new RuntimeException("Wrong input values from =" + from + " and to =" + to);
		}
	}
	
	public void generatePrimes(){
		for (long number = from; number <= to; number++) {
			if(numberIsPrime(number)){ 
				primes.add(number); 
			}
        }
	}
	
	protected boolean numberIsPrime(long number) {
		// TODO Auto-generated method stub
		if(number<= 1){ 							// Any number less than equal to 1 is not prime. 
			return false; 
		}
		if( number > 2 && numberIsEven(number) ){ 	// All even numbers except 2 are not prime.
			return false; 
		}
		long num; 
        for (num=(long)Math.sqrt(number); number%num!=0 && num>=1; num--){}	// If num divides number, then number is not prime else it is prime. 
        if (num==1){ 
        	return true;
        }
        else{ 
        	return false; 
        }
	}

	protected boolean numberIsEven(long number) {
		// TODO Auto-generated method stub
		if(number%2 == 0){ 
			return true; 
		}
		else{ 
			return false; 
		}
	}

	public LinkedList<Long> getPrimes(){ return primes; };
	
	public static void main(String[] args) {
		PrimeGenerator gen = new PrimeGenerator(1, 100);
		gen.generatePrimes();
		LinkedList<Long> primes = gen.getPrimes();
		Iterator<Long> iterator = primes.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + ", ");
		}
		System.out.println("\n" + gen.getPrimes().size() + " primes are found.");								
	}
}

