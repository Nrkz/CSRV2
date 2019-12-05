package org.inria.restlet.mta.internals;

public class Tweet{
		
		
		/** Content of the tweet.*/
		private String content;
		
		
		/** Internal id of the Tweet.*/
		private int id;
		
		/** Ajouter le nb de RT de like, le fil de r�ponses etc... utile ? **/
		
		public Tweet(String content){
			this.content = content;
		}
		
		
		public void setContent(String content){
			this.content = content;
		}
		
		public String getContent(){
			return this.content;
		}
		
		public int getId(){
			return this.id;
		}
		
		public void setId(int id){
			this.id = id;
		}
		
}