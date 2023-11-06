package com.example.university.decorators;

// Abstract class of the Certificate Decorator
public abstract class CertificateDecorator implements I_Certificate{
  protected I_Certificate certificate;

  public CertificateDecorator(I_Certificate certificate) {
    this.certificate = certificate;
  }
}
