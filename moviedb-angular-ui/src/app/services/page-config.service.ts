import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PageConfigService {

  constructor(private http: HttpClient) { }

  getContentConfig() {
    return this.http.get('assets/config/contentConfig.json');
  }
  getResourceConfig() {
    return this.http.get('assets/config/resourceConfig.json');
  }
  getMovieData(params){
    let queryParams ='?';
    if(params.movieName != undefined){
      queryParams = queryParams +'movieName='+params.movieName+"&";
    }
    if(params.categoryName != undefined){
      queryParams = queryParams +'categoryName='+params.categoryName+"&";
    }
    if(params.year != undefined){
      queryParams = queryParams +'year='+params.year+"&";
    }
    if(params.actorName != undefined){
      queryParams = queryParams +'actorName='+params.actorName+"&";
    }
    if(params.directorName != undefined){
      queryParams = queryParams +'directorName='+params.directorName+"&";
    }
    if(params.producerName != undefined){
      queryParams = queryParams +'producerName='+params.producerName+"&";
    }
    let url = '/moviedbsearch/api/v1/search';
    if(queryParams != '?'){
      url = url+queryParams;
    }
    return this.http.get(url);
  }
}
