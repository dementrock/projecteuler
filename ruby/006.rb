puts ((1..100).inject(:+)) ** 2 - (1..100).collect{|x| x ** 2}.inject(:+)
