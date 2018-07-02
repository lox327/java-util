public static boolean isPerfect (int num) {
		
	int sum = 1;

	for (int i = 2; i < num; i++) {
		if (num%i == 0) sum +=i;
		else if (i > num/2) break;

	}
	return sum==num;
}
