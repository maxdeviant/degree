class Fibonacci():

    def run(self):
        i = 0
        while i < 100:
            print self.fibonacci(i)
            i += 1

        return True

    def fibonacci(self, n):
        return self.fibonacciAux(n, 0, 1)

    def fibonacciAux(self, n, a, b):
        if not n < 0:
            result = self.fibonacciAux(n - 1, b, a + b)

        else:
            result = a

        return result


if __name__ == '__main__':
    print Fibonacci().run()
