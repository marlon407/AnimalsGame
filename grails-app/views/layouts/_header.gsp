<!DOCTYPE html>
<nav class="top-bar" data-topbar role="navigation">
  <ul class="title-area">
    <li class="name">
      <h1><a href="/Animals">Game animal</a></h1>
    </li>
     <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
  </ul>

  <section class="top-bar-section">
    <!-- Right Nav Section -->
    <ul class="right">
      <li class="active"><a href="https://github.com/marlon407/AnimalsGame">Github</a></li>
      <li class="has-dropdown">
        <a href="#">Mais</a>
        <ul class="dropdown">
          <li><a href="${createLink(action: 'rules', controller: 'Animal')}">Regras</a></li>
          <li><a href="${createLink(action: 'instructions', controller: 'Animal')}">Instruções</a></li>
        </ul>
      </li>
    </ul>

    <!-- Left Nav Section -->
    <ul class="left">
        <li><a href="${createLink(action: 'clearAll', controller: 'Animal')}">Limpar registros</a></li>
    </ul>
  </section>
</nav>