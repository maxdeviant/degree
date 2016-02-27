class Boolean:
	def exp(self):
		result = True
		result =  not result
		result =  not (result and  not result) or result and (result)
		return result and 5 == 5


if __name__ == '__main__':
	print(Boolean().exp())
