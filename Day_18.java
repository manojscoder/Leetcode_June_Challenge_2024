// Problem link: https://leetcode.com/problems/most-profit-assigning-work/description/

// Solution: 1 (two-pointer and sorting)
// Time: O(nlogn)
// Space: O(n)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int result = 0, idx = 0, maxProfit = 0;

        Arrays.sort(worker);
        int[][] store = new int[profit.length][2];

        for(int i = 0; i < profit.length; i++) {
            store[i][0] = difficulty[i];
            store[i][1] = profit[i];
        }

        Arrays.sort(store, (a, b) -> Integer.compare(a[0], b[0]));

        for(int w : worker) {

            while(idx < store.length && w >= store[idx][0])
                maxProfit = Math.max(maxProfit, store[idx++][1]);
            
            result += maxProfit;
        }

        return result;
    }
}



// Solution: 2 (Binary search and sorting profit)
// Time: O(nlogn)
// Space: O(n)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] store = new int[profit.length + 1][2];
        int totalProfit = 0, left, right, jobProfit, mid;
        
        for(int i = 1; i < profit.length + 1; i++) {
            store[i][0] = profit[i - 1];
            store[i][1] = difficulty[i - 1];
        }

        Arrays.sort(store, (a, b) -> Integer.compare(b[0], a[0]));

        for(int i = 0; i < profit.length - 1; i++)
            store[i + 1][1] = Math.min(store[i][1], store[i + 1][1]);
        
        for(int w : worker) {
            left = 0;
            right = store.length - 1;
            jobProfit = 0;

            while(left <= right) {
                mid = (int)((left + right) / 2);
                if(store[mid][1] <= w) {
                    jobProfit = Math.max(jobProfit, store[mid][0]);
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

            totalProfit += jobProfit;
        }

        return totalProfit;
    }
}


// Solution : 2 (Binary search and sorting the difficulty)
// Time: O(nlogn)
// Space: o(n)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] store = new int[profit.length + 1][2];
        int totalProfit = 0, left, right, jobProfit, mid;
        
        for(int i = 1; i < profit.length + 1; i++) {
            store[i][0] = difficulty[i - 1];
            store[i][1] = profit[i - 1];
        }

        Arrays.sort(store, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 1; i < profit.length - 1; i++)
            store[i + 1][1] = Math.max(store[i][1], store[i + 1][1]);
        
        for(int w : worker) {
            left = 0;
            right = store.length - 1;
            jobProfit = 0;

            while(left <= right) {
                mid = (int)((left + right) / 2);
                if(store[mid][0] <= w) {
                    jobProfit = Math.max(jobProfit, store[mid][1]);
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            totalProfit += jobProfit;
        }

        return totalProfit;
    }
}


// Solution: 4 (Memoization)
// Time: O(n + m + maxWork)
// Space: O(maxWork)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxAbility = 0, result = 0;

        for(int w : worker)
            maxAbility = Math.max(w, maxAbility);

        int[] jobs = new int[maxAbility + 1];

        for(int i = 0; i < profit.length; i++)
            if(difficulty[i] <= maxAbility)
                jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
        
        for(int i = 1; i <= maxAbility; i++) 
            jobs[i] = Math.max(jobs[i], jobs[i - 1]);
        
        for(int w : worker)
            result += jobs[w];
        
        return result;
    }
}
