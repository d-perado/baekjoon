var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');

const Node = class {
  position;
  prev;
  next;
  constructor(y, x) {
    this.position = [y, x];
  }
};

const solution = (N, K, applePositions, L, directionInfo) => {
  // dy dx: 명령어가 D일 경우 +1, L일 경우 -1하여 다음 dy dx를 구함
  const DIRECTION_ORDER = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];
  let directionIdx = 0;
  // 뱀의 위치 저장 및 초기화
  const snake = new Set();
  let head = new Node(0, 0);
  let tail = head;
  snake.add('0,0');
  let time = 0;
  let isFinish = false;

  // 뱀 move 함수
  const moveSnake = () => {
    const [dy, dx] = DIRECTION_ORDER[directionIdx];
    const [currentY, currentX] = head.position;
    const [nextY, nextX] = [currentY + dy, currentX + dx];
    const newKey = `${nextY},${nextX}`;

    if (snake.has(newKey)) return true; // 뱀의 몸에 부딪힌 경우
    if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) return true; // 벽에 부딪힌 경우

    snake.add(newKey);
    const newHead = new Node(nextY, nextX);
    newHead.prev = head;
    head.next = newHead;
    head = newHead;
    const appleIdx = applePositions.findIndex(
      ([y, x]) => nextY === y && nextX === x
    );
    if (appleIdx === -1) {
      const [tailY, tailX] = tail.position;
      const tailKey = `${tailY},${tailX}`;
      snake.delete(tailKey);
      tail = tail.next;
      tail.prev = null;
    } else {
      applePositions.splice(appleIdx, 1);
    }

    return false;
  };

  // 게임 진행
  while (!isFinish) {
    if (directionInfo[0] && Number(directionInfo[0][0]) === time) {
      const [_, command] = directionInfo.shift();
      if (command === 'D') directionIdx = (directionIdx + 1) % 4;
      else {
        directionIdx--;
        if (directionIdx < 0) directionIdx += 4;
      }
    }

    time++;
    isFinish = moveSnake();
  }
  return time;
};

const N = Number(input[0]);
const K = Number(input[1]);
const applePositions = input
  .slice(2, 2 + K)
  .map((v) => v.split(' ').map((v) => Number(v) - 1));
const L = Number(input[2 + K]);
const directionInfo = input.slice(3 + K).map((v) => v.split(' '));
console.log(solution(N, K, applePositions, L, directionInfo));