const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let [n, ...input] = fs.readFileSync(filePath).toString().trim().split(/\r\n/)

Loop1: for (let i = 0; i < Number(n); i++) {
  const phoneNoCnt = Number(input.shift()) //전화번호 갯수
  const arr = input.slice(0, phoneNoCnt)
  input = input.slice(phoneNoCnt)
  arr.sort()
  for (let j = 0; j < Number(phoneNoCnt) - 1; j++) {
    //번호수만큼비교
    if (arr[j].length >= arr[j + 1].length) continue
    if (arr[j] === arr[j + 1].slice(0, arr[j].length)) {
      console.log("NO")
      continue Loop1
    }
  }
  console.log("YES")
}
//25%에서 틀렸습니다 가 뜬다 왜 그런지 모르겠다.
