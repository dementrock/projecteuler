puts lambda { |x|
  x[0][0] * x[0][1] * (1000 - x[0][0] - x[0][1])
}.(
  Array(1..1000).product(Array(1..1000)).select { |x|
    x[0] <= x[1] and
    x[0] + x[1] < 1000 and
    x[0] ** 2 + x[1] ** 2 == (1000 - x[0] - x[1]) ** 2
  }
)
