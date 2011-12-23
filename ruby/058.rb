"""
For side length 2k + 1:

(2k+1)^2 - 4k   (2k+1)^2 - 6k
(2k+1)^2 - 2k   (2k+1)^2
"""

require 'utils'
Integer.sieve(1_000_000)

cnt = 1
cnt_prime = 0
(1..(1.0/0.0)).each do |k|
  cnt += 4
  (0..6).step(2).each do |inc|
    if ((2 * k + 1) ** 2 - inc * k).prime?
      cnt_prime += 1
    end
  end
  if cnt_prime * 10 < cnt
    puts 2 * k + 1
    break
  end
end
