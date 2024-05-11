package asst.unicauca.edu.co.parcialparteii.infraestructura.output.controladorExcepciones.excepcionesPropias;

import asst.unicauca.edu.co.parcialparteii.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionClientesRuntimeException extends RuntimeException {

  protected CodigoError codigoError;

  public abstract String formatException();
}
