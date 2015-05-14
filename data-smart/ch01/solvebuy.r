solveBy <- function(csvfile, total = 2400) {
  # IP package
  require("lpSolve")
  # read csv
  items.data <- read.csv(file=csvfile, header=TRUE)
  n <- length(items.data[,1])
  # it's a minimization
  prob.dir <- "min"
  # minimize the number of items
  prob.objective <- rep(1, n)
  # the total of calories
  prob.constraints <- rbind(items.data$Calories)
  # is equal
  prob.const.dir <- c("=")
  # to total
  prob.const.rhs <- c(total)
  
  lp(direction = prob.dir, objective.in = prob.objective,
     const.mat = prob.constraints, const.dir = prob.const.dir,
     const.rhs = prob.const.rhs, int.vec = c(1:n), all.int = TRUE)  
}
