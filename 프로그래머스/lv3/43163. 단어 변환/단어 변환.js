function solution(begin, target, words) {
    // 예외처리
    // 배열 words 요소중 target이 없는 경우
    // 0을 반환
    if(words.filter((el) => el === target).length === 0)
        return 0;
    
    const check = (original, compare) => {
       
        let cnt = 0;
        let result = false;
        let len = original.length;
        for(let i = 0; i < len; i++) {
            if(original[i] === compare[i])
                cnt++;
        }

        if(cnt === len - 1) 
            result = true;
        
        return result;
    }
    
    const DFS = (isVisited, presentBegin, cnt) => {
        // 만약 현재 문자열과 target 문자열이 같으면
        // result 배열에 cnt를 저장
        // 다음 경우의 수를 찾는다 (return)
        if(presentBegin === target) {
            answer.push(cnt);
            return;
        }
        
        let list = isVisited.map((el, idx) => {
            if(el === false) return idx;
        }).filter((el) => el !== undefined);
        
        if(list.length === 0) return;
        
        for(let i = 0; i < list.length; i++) {
            let copy = isVisited.slice();
            let index = list[i];
            let nextWord = words[index];
            
            // 현재 문자열에서 다음 문자열 변환 가능한지 체크
            
            if(check(presentBegin, nextWord)) {
                let nextBegin = nextWord;
                let copyCnt = cnt + 1;
                let copy = isVisited.slice();
                
                copy[index] = true;
                
                DFS(copy, nextBegin, copyCnt);
            }
        }
        
        return;
    }
    
    let answer = [];
    
    for(let i = 0; i < words.length; i++) {
        
        let cnt = 0;
        let nextWord = words[i];
        
        // 현재 문자열에서 다음 문자열 변환 가능한지 체크
        let isValid = check(begin, nextWord);
        
        if(isValid === true) {
            let nextBegin = nextWord;
            cnt++;
            let isVisited = new Array(words.length).fill(false);
            
            isVisited[i] = true;
            
            DFS(isVisited, nextBegin, cnt);
        }
    }
    
    if(answer.length === 0) 
        return 0;
    else 
        return Math.min(...answer);
}