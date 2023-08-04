document.addEventListener('DOMContentLoaded', (event) => {
    let collapserElements = document.querySelectorAll('[data-bs-toggle="collapse"]');

    collapserElements.forEach((el) => {
        el.addEventListener('click', () => {
            collapserElements.forEach((otherEl) => {
                let otherCollapseEl = document.querySelector(otherEl.getAttribute('href'));
                if (otherEl !== el && otherCollapseEl.classList.contains('show')) {
                    var bootstrapCollapse = new bootstrap.Collapse(otherCollapseEl, {
                        toggle: false
                    });
                    bootstrapCollapse.hide();
                }
            });
        });
    });
});