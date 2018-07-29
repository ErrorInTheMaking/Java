class primes{
    public static boolean filter_prime(int n){
        if(n < 2)
            return false;
        if(n==2)
            return true;
        else{
            for(int i = 2; i <= n/2; ++i){
                if(n % i == 0)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        if(filter_prime(n))
            System.out.println(n + " is prime");
        else
            System.out.println(n + " not prime");
    }
}
