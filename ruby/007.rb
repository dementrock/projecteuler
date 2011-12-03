require 'prime'
count = 0
(1..(1.0/0.0)).each { |x|
  count += 1 if Prime.prime? x
  if count == 10001
    puts x
    break
  end
}
