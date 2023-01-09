function solution(n, computers) {
    var answer = 0;
    var visited=new Array(n).fill(false)
    
    
    function dfs(comno){
        if(visited[comno]===true)return;
        visited[comno]=true
        for(let i=0;i<computers.length;i++){
            if(computers[comno][i]===1){
                if(visited[i]===false){
                    dfs(i)
                }
            }
        }
    }    
    for (let i=0; i < computers.length; i++) {
        if (!visited[i]) {
            dfs(i)
            answer++;
        }
    }
    
    
    return answer;
}