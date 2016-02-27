class Slice:
	def slice(self, n):
		self.arr = [None]*n * 5
		i = 0
		while i < n:
			self.arr[i] = 5
			i += 1
		newArr = self.arr[:]
		newArr = newArr[:n]
		sum = 0
		i = 0
		while i < len(newArr):
			sum += newArr[i]
			i += 1
		return sum


if __name__ == '__main__':
	print(Slice().slice(6))
