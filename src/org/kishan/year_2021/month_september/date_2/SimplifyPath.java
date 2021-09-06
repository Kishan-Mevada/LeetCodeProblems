package org.kishan.year_2021.month_september.date_2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * 	Given a string path, which is an absolute path to a file or directories in Unix-style file system. convert it in the
 * 	simplified canonical path
 *
 * 	input 				output
 * 	/home/				/home
 * 	/../				/
 * 	/home//foo/			/home/foo
 * 	/a/./b/../../c/		/c
 *
 * 	 Solution Algorithms
 *
 * 	 - create queue
 * 	 - split string into array of directories by /
 * 	 - Iterate directories array, denoted as dir
 * 	 	- if dir is empty or dir is '.'
 * 	 		- continue to next iteration
 * 	   - if dir is '..'
 * 	   		- if queue is not empty
 * 	   			- poll element from queue
 * 	   - else
 * 	   		- add dir to stack
 *
 * 	 - create StringBuilder, denoted as result
 * 	 - while queue is not empty
 * 	 	- append / to result
 * 	 	- append queue.remove() to result
 * 	- if result is empty
 * 		- append / to result
 *  - return result.toString()
 *
 *  -- Time :  O(3 * n) = O(n)
 *  -- Space : O(3 * n) = O(n)
 *
 */
public class SimplifyPath {

	static String simplifyPath(String path){
		Queue<String> stack = new ArrayDeque<>();
		String[] directories = path.split("/");
		for(String dir : directories){
			if(dir.isEmpty() || ".".equals(dir)){
				continue;
			}
			if("..".equals(dir) && !stack.isEmpty()){
				stack.poll();
			}
			else{
				stack.add(dir);
			}
		}

		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()){
			result.append("/").append(stack.remove());
		}
		if(result.toString().isEmpty()){
			result.append("/");
		}
		return result.toString();
	}
	public static void main(String[] args) {
		String path = "/home/";
		System.out.println("Simplified Path -> " + simplifyPath(path));
	}
}
