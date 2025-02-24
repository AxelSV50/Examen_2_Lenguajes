import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WebApiService } from './web-api.service';
import { HttpClient } from '@angular/common/http';

var apiUrl = "http://localhost:8080";

var httpLink = {
  getAllMajors: apiUrl + "/api/major/getAllMajors",
  deleteMajorById: apiUrl + "/api/major/deleteMajorById/",
  getMajorDetailById: apiUrl + "/api/major/getMajorById",
  saveMajor: apiUrl + "/api/major/saveMajor"
}

@Injectable({
  providedIn: 'root'
})
export class HttpProviderService {

  constructor(private webApiService: WebApiService, private httpClient: HttpClient) { }

  public getAllMajors(): Observable<any> {
    return this.webApiService.get(httpLink.getAllMajors);
  }

  public deleteMajorById(model: any): Observable<any> {
    return this.httpClient.delete(httpLink.deleteMajorById + model);
  }

  public getMajorDetailById(model: any): Observable<any> {
    return this.webApiService.get(httpLink.getMajorDetailById + '/' + model);
  }

  public saveMajor(model: any): Observable<any> {
    return this.webApiService.post(httpLink.saveMajor, model);
  }
  
}
