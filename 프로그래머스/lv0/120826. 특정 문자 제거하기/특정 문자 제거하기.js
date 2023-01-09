function solution(my_string, letter) {
    var answer = '';
    my_string.split('').map((i)=>{
        if(i===letter){
            i=''
        }else{
            answer+=i
        }
    })
    return answer;
}