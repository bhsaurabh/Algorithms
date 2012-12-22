#!/usr/bin/python -tt
""" 
	Multiplies 2 numbers using Karatsuba's multiplication algorithm
	TODO:
	Fix Bug where there is a Recursion depth exceeded error
	Fix Bug: incorrect count of digits returned for numbers preceded with 0
"""
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 
# Name of program: karatsuba.py 																  #
# Author: Saurabh Bhatia																		  #
# Date: 22nd December, 2012																		  #
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 
from random import randint
from sys import exit

def multiply(x,y):
	"""
	Takes 2 numbers as input (both should have same number of digits)
	Returns their multiplication if they are single digits.
	Else performs recursive operation
	"""
	try:
		# check sign of final answer
		if (x < 0 and y > 0):
			sign = -1
			x *= sign
		elif(x > 0 and y < 0):
			sign = -1
			y *= sign
		else:
			sign = +1


		# Check for single bit
		if x < 10 and y < 10:
			return x*y
		else:
			# Find number of digits in a
			xdigit = 0
			while True:
				if x / int(pow(10,xdigit)) == 0:
					break
				else:
					xdigit += 1
			# if xdigit is odd...make it even by adding zeroes ahead
			if xdigit % 2 != 0:
				# increase xdigit by 1
				xdigit += 1
			ydigit = xdigit # since number of digits in the 2 numbers is same
			if xdigit % 2 == 0:
				a = x / pow(10,xdigit/2)
				b = x - (a * pow(10,xdigit/2))
			if ydigit % 2 == 0:
				c = y / pow(10,ydigit/2)
				d = y - (c * pow(10,ydigit/2))
			ac = multiply(a,c)
			bd = multiply(b,d)
			big_term = multiply(a+b,c+d)
			imp_term = big_term - ac - bd
			return (pow(10,xdigit)*ac + pow(10,xdigit/2)*imp_term + bd)*sign
	except RuntimeError:
		"""Recursion depth exceeded
		Starting new series of tests..."""
		test()
		return -1
def test():
	"""
		This function tests the Karatsuba algorithm implemented in the program
		It uses 100 test cases of valid inputs
		In case recursive depth is exceeded (which happens quite often), the whole program is called again.
		Hence in most cases, where the program has terminated (which also happens quite often), more than 100 test cases have been performed.
	"""
	for j in range(100):
		a = randint(-1000,1000)
		b = randint(-1000,1000)
		
		ans1 = multiply(a,b)
		ans2 = a*b
		if ans1 != ans2:
			print "*********************************************************"
			print "Error at case #:", (i+1)
			print "num1 = ",a,"num2 = ",b," --> ",
			print "answer = ",ans1,"STATUS: WRONG, -> Correct answer:", ans2
			print "*********************************************************"
			exit(1)
		else:
			print "num1 = ",a,"num2 = ",b," --> ",
			print "answer = ",ans1,"STATUS: Correct" 		
	print "All tests completed successfully, without any errors."
	exit(0)



if __name__ == '__main__':
	test()