
public class Primechecker {

Primechecker(){
super();
}
public static void main(String[] args){
	checkPrime(5);
	checkPrime(6);
	checkPrime(2);
	checkPrime(13);
}
void checkPrime(int n) {
    for(int i=2;i<n/2;i++) {
        if(n%i==0){
        System.out.println(false);
	return;
	}
    }
    System.out.println(true);
}

}