class Fib:
	def fib(self, n):
		if n < 3:
			result = 1
		else:
			result = self.fib(n - 1) + self.fib(n - 2)
		return result


if __name__ == '__main__':
	print(Fib().fib(5))
