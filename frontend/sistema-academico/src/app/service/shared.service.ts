import { Injectable } from '@angular/core';

import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  private subject = new Subject<any>();

  sendEditEvent(v) {
    this.subject.next(v);
  }
  getEditEvent(): Observable<any>{ 
    return this.subject.asObservable();
  }

  constructor() { }
}
