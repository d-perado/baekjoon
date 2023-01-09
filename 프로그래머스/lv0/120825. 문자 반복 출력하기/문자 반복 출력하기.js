function solution(my_string, n) {
    var answer = '';
    
    my_string.split('').map((i)=>{for(let j=0;j<n;j++){
        answer+=i
    }})
    
    
    return answer;
}