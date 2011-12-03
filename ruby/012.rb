require 'prime'
(2..(1.0/0.0)).each {|x|
  if (Prime.prime_division(x * (x + 1) / 2).collect{|prime, exp| exp + 1}.inject(:*)) > 500
    puts x * (x + 1) / 2
    break
  end
}
