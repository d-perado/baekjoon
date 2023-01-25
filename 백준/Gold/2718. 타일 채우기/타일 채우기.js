const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
const [T, ...input] = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n")
  .map(Number)

const dp = new Array(500).fill(0)
dp[0] = 1
dp[1] = 5
dp[2] = 11
dp[3] = 36

let cnt = 5
for (let i = 0; i < T; i++) {
  if (dp[input[i] - 1] === 0) {
    for (let j = cnt - 1; j < input[i]; j++) {
      dp[j] = dp[j - 1] + dp[j - 2] * 5 + dp[j - 3] - dp[j - 4]

      //j-1 << 앞의 타일 배치 수와 동일 앞의타일배치 + 일자로
      //j-2 << 두개타일로 배치될 수있는 가짓 수 중
    }
  }
  console.log(dp[input[i] - 1])
  cnt = Math.max(cnt, input[i])
}
