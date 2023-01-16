const fs= require("fs")
const [...input]= fs.readFileSync('/dev/stdin').toString().trim().split('-')
let answer=''
for(let i=0;i<input.length;i++){
    answer+=input[i][0]
}

console.log(answer)
