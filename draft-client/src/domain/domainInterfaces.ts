export default interface Team {
  id: number;
  name: string;
  city: string;
  state: string;
  conference: string;
}
export default interface Pick {
  id: number;
  teamId: number;
  selectionRound: number;
  selectionNumber: number;
  selectionYear: string;
  selectionFrom: string;
  selectionSentTo: string;
  combineScore: number;
}
export default interface Player {
  id: number;
  firstName: string;
  lastName: string;
  age: number;
  height: number;
  weight: number;
  handSize: number;
  armLength: number;
  homeCity: string;
  homeState: string;
  university: string;
  pickId: number;
  position: string;
}
export default interface CombineScore {
  id: number;
  fortyTime: number;
  tenYardSplit: number;
  twentyYard_shuttle: number;
  threeCone: number;
  verticalLeap: number;
  broadJump: number;
  playerId: number;
}

export default interface Schedule {
  id: number;
  teamID: number;
  opponentId: number;
  scheduleWeek: number;
  gameDate: Date;
  gameCity: string;
  gameStateProvince: TemplateStringsArray;
  gameCountry: string;
  gameLocation: string;
  opponentConference: string;
  opponentDivision: string;
  winLostFlag: string;
  homeOrAway: string;
}
