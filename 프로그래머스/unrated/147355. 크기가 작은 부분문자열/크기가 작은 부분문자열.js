function solution(t, p) {
    var answer = 0;
    let sbstring=new Array();
    
    
    for(let i=0;i<t.length-p.length+1;i++){
        
        if(Number(t.slice(i,i+p.length))<=Number(p)){
            
            sbstring.push(Number(t.slice(i,i+p.length)))
            
        }
        
    }
    
    answer=sbstring.length
    return answer;
}