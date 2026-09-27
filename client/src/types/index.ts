export interface ApiResponse<T> {
  success: boolean;
  message: string;
  data: T;
  timestamp: string;
}

export type SportCategory = 'TREKKING' | 'TRAIL_RUNNING' | 'CAMPING' | 'CYCLING' | 'PADDLING';
export type DifficultyLevel = 'EASY' | 'MODERATE' | 'CHALLENGING' | 'EXTREME';
export type Region = 'NORTH_WEST' | 'NORTH_EAST' | 'CENTRAL_HIGHLANDS' | 'SOUTH' | 'CENTRAL';

export interface AuthorSummary {
  id: string;
  username: string;
  fullName: string;
  avatarUrl: string;
  summitsCount: number;
  level: number;
  isLeaveNoTraceAmbassador: boolean;
}

export interface TrailSummary {
  id: number;
  name: string;
  slug: string;
  region: Region;
  peakElevation: number;
  elevationGain: number;
  distanceKm: number;
  difficultyLevel: DifficultyLevel;
  coverImageUrl: string;
}

export interface Post {
  id: string;
  author: AuthorSummary;
  caption: string;
  sportCategory: SportCategory;
  mediaUrls: string[];
  taggedTrail?: TrailSummary;
  distanceKm?: number;
  elevationGainMeters?: number;
  durationDays?: number;
  weatherCondition?: string;
  isSummitVerified: boolean;
  kudosCount: number;
  commentCount: number;
  shareCount: number;
  createdAt: string;
}
