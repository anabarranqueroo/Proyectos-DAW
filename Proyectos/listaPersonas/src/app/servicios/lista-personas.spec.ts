import { TestBed } from '@angular/core/testing';

import { ListaPersonas } from './lista-personas';

describe('ListaPersonas', () => {
  let service: ListaPersonas;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaPersonas);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
