function solution(numbers) {

const sum1 = numbers.reduce((accumulator, currentNumber) => accumulator + currentNumber);
    return sum1/numbers.length;
}