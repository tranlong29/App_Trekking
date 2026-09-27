import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        forest: {
          DEFAULT: "#1B4332",
          dark: "#081C15",
          light: "#2D6A4F",
          sage: "#74C69D",
          tint: "#D8F3DC",
        },
        terracotta: {
          DEFAULT: "#D97736",
          dark: "#B85D24",
          light: "#F4A261",
        },
        canvas: {
          DEFAULT: "#F6FBF4",
          stone: "#E9EFE6",
        },
      },
      fontFamily: {
        sans: ["var(--font-plus-jakarta)", "system-ui", "sans-serif"],
        display: ["var(--font-space-grotesk)", "system-ui", "sans-serif"],
      },
    },
  },
  plugins: [],
};
export default config;
