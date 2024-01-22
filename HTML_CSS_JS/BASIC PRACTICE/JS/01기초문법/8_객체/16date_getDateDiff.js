const date1 = new Date('2022-12-23');
const date2 = new Date('2022-12-25');
const dateDiff = date2.getTime() - date1.getTime();
const interval = dateDiff / (24 * 60 * 60 * 1000);      // 24시간*60분*60초*1000밀리초
console.log(`두 날짜의 차이는 ${interval}일입니다.`);      // 두 날짜의 차이는 2일입니다.